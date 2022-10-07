package com.example.demo;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.ListSeries;
import com.vaadin.addon.charts.model.PlotOptionsColumn;
import com.vaadin.addon.charts.model.Stacking;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.dialog.Dialog;
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

    calculateBP.addClickListener(click -> {

     String res = BusinessLogic.checkBloodPressureStatus(
         (systolicValue.getValue()),diastolicValue.getValue());

      Notification.show(res,7000, Notification.Position.MIDDLE);
      //add(new Paragraph(res));
      systolicValue.setValue(null);
      diastolicValue.setValue(null);


   /* Dialog dialog = new Dialog();
    Button deleteButton = new Button("Delete", (e) -> dialog.close());

    deleteButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY,
        ButtonVariant.LUMO_ERROR);
    deleteButton.getStyle().set("margin-right", "auto");
    dialog.getFooter().add(deleteButton);
    add(deleteButton);

    Button cancelButton = new Button("Cancel", (e) -> dialog.close());
    cancelButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
    dialog.getFooter().add(cancelButton);
    add(cancelButton);*/
    });
    calculateBP.addClickShortcut(Key.ENTER);
    Chart chart = new Chart(ChartType.BAR);
    chart.setWidth("400px");  // 100% by default
    chart.setHeight("300px"); // 400px by default
    chart.drawChart();

    ListSeries series = new ListSeries(50, 60, 70, 80);
    PlotOptionsColumn plotOptions = new PlotOptionsColumn();
    plotOptions.setStacking(Stacking.NORMAL);
    series.setPlotOptions(plotOptions);

  }

}
