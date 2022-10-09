package com.example.demo;

import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.PlotOptionsColumn;
import com.vaadin.addon.charts.model.Stacking;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.ui.GridLayout;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Collection;

@PageTitle("BloodPressureCalculator")
@Route("")
public class MainView extends VerticalLayout {

  public MainView() {

    H1 header = new H1("Blood Pressure Calculator");
    header.getStyle().set("margin","auto");
    header.getStyle().set("color","orange");
    add(header);

    IntegerField systolicValue = new IntegerField("Enter Systolic Value (mmHG)");
    IntegerField diastolicValue = new IntegerField("Enter Diastolic Value (mmHG)");


    systolicValue.setRequiredIndicatorVisible(true);
    systolicValue.setWidth(275,Unit.PIXELS);

    diastolicValue.setRequiredIndicatorVisible(true);
    diastolicValue.setWidth(275,Unit.PIXELS);

    systolicValue.setPlaceholder("Systolic Value");
    diastolicValue.setPlaceholder("Diastolic Value");

    HorizontalLayout horizontalLayout = new HorizontalLayout(systolicValue,diastolicValue);
    horizontalLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER);
    horizontalLayout.getStyle().set("margin","auto");
    add(horizontalLayout);

    Button calculateBP = new Button("Calculate BP");
    calculateBP.getStyle().set("color","black");
    calculateBP.getStyle().set("margin","auto");

    add(calculateBP);
    add(new Hr());

    calculateBP.addClickListener(click -> {

     String res = BusinessLogic.checkBloodPressureStatus(
         (systolicValue.getValue()),diastolicValue.getValue());
      //add(new Hr());

     Notification notification = Notification.show(systolicValue.getValue()+ " / " +diastolicValue.getValue()+ " , "+res,7000, Notification.Position.MIDDLE);
      switch (res) {
        case BloodPressureConstants.LOW:
          notification.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
          break;
        case BloodPressureConstants.IDEAL:
          notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
          break;
        case BloodPressureConstants.PREHIGH:
          notification.addThemeVariants(NotificationVariant.LUMO_PRIMARY);
          break;
        default:
          notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
          break;
      }
      systolicValue.setValue(null);
      diastolicValue.setValue(null);
    });

    calculateBP.addClickShortcut(Key.ENTER);
    //newFeature(systolicValue,diastolicValue);

  }

}
