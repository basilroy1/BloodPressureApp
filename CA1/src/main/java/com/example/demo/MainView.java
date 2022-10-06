package com.example.demo;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Input;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.w3c.dom.html.HTMLTitleElement;

@PageTitle("BloodPressureCalculator")
@Route("")
public class MainView extends VerticalLayout {

  public MainView() {
    add(new H1("Blood Pressure Calculator"));

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

    add(horizontalLayout);

    Button calculate_bp = new Button("Calculate BP");
    calculate_bp.getStyle().set("color","black");
    calculate_bp.getStyle().set("margin-left","200px");
    add(calculate_bp);


    calculate_bp.addClickListener(click -> {

     String res = BusinessLogic.checkBloodPressureStatus(
         (systolicValue.getValue()),diastolicValue.getValue());

      Notification.show("Hi, You have "+res,7000, Notification.Position.MIDDLE);
      //add(new Paragraph(res));
      systolicValue.setValue(null);
      diastolicValue.setValue(null);
  });
    calculate_bp.addClickShortcut(Key.ENTER);
  }
}
