package com.example.demo;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class MainViewTest {
  @Mock
  private MainView mainView3;
  @Mock
  private MainView mainView;
  @Mock
  private BusinessLogic businessLogic;
  private IntegerField systolicVal;
  private IntegerField diastolicVal;
  private String res;
  private Notification notification;

  @BeforeEach
  public void setupData() {
    mainView = new MainView();
    mainView3 = new MainView();
    systolicVal = new IntegerField("Systolic Value (mmHG)");
    diastolicVal = new IntegerField("Diastolic Value (mmHG)");
    notification = new Notification();

    systolicVal.setValue(110);
    diastolicVal.setValue(70);

    res = BusinessLogic.checkBloodPressureStatus(
        (systolicVal.getValue()),diastolicVal.getValue());

  }
  @Test
  void newFeatureTest(){

    MainView ideal  = new MainView();
    ideal.onlineGPAdvice(systolicVal,diastolicVal,res);

    Assertions.assertEquals(BloodPressureConstants.IDEAL,res);

    MainView low  = new MainView();
    systolicVal.setValue(80);
    diastolicVal.setValue(50);
    res = BusinessLogic.checkBloodPressureStatus(
        (systolicVal.getValue()),diastolicVal.getValue());
    low.onlineGPAdvice(systolicVal,diastolicVal,res);

    Assertions.assertEquals(BloodPressureConstants.LOW,res);

    MainView prehigh  = new MainView();
    systolicVal.setValue(130);
    diastolicVal.setValue(85);
    res = BusinessLogic.checkBloodPressureStatus(
        (systolicVal.getValue()),diastolicVal.getValue());
    prehigh.onlineGPAdvice(systolicVal,diastolicVal,BloodPressureConstants.PREHIGH);

    Assertions.assertEquals(BloodPressureConstants.PREHIGH,res);

    MainView high  = new MainView();
    systolicVal.setValue(150);
    diastolicVal.setValue(97);
    res = BusinessLogic.checkBloodPressureStatus(
        (systolicVal.getValue()),diastolicVal.getValue());
    high.onlineGPAdvice(systolicVal,diastolicVal,BloodPressureConstants.HIGH);

    Assertions.assertEquals(BloodPressureConstants.HIGH,res);

    MainView invalidSystolic  = new MainView();
    systolicVal.setValue(60);
    diastolicVal.setValue(47);
    res = BusinessLogic.checkBloodPressureStatus(
        (systolicVal.getValue()),diastolicVal.getValue());
    invalidSystolic.onlineGPAdvice(systolicVal,diastolicVal,BloodPressureConstants.INVALID_SYSTOLIC);

    Assertions.assertEquals(BloodPressureConstants.INVALID_SYSTOLIC,res);

    MainView invalidDiastolic = new MainView();
    systolicVal.setValue(72);
    diastolicVal.setValue(30);
    res = BusinessLogic.checkBloodPressureStatus(
        (systolicVal.getValue()),diastolicVal.getValue());
    invalidDiastolic.onlineGPAdvice(systolicVal,diastolicVal,BloodPressureConstants.INVALID_DIASTOLIC);

    Assertions.assertEquals(BloodPressureConstants.INVALID_DIASTOLIC,res);
  }
  @Test
  void notificationPopUpTestLOW(){

   //mainView.notificationPopUp(systolicVal,diastolicVal,res);
   //notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    //Assertions.assertEquals(notification.getThemeName(),"LUMO_SUCCESS");

    //Assertions.assertEquals(Notification.show());
  }

  @Test
  void calculateBP(){

    Button button = new Button();
    new MainView();
    String res = businessLogic.checkBloodPressureStatus(80,60);
    button.addClickListener(e -> {
      mainView.calculateBPonClick(button,systolicVal,diastolicVal);
    });
    button.click();
    Assertions.assertEquals(BloodPressureConstants.IDEAL,res);

  }
}

