package com.example.demo;

import com.example.demo.businesslogic.BusinessLogic;
import com.example.demo.constants.BloodPressureConstants;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.IntegerField;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {

  @Given("I am on BP calculate home page")
  public void iAmOnBPCalculateHomePage() {
  }
  @And("I have entered my Systolic value of {int} and my Diastolic value of {int}")
  public void i_have_entered_my_systolic_value_of_and_my_diastolic_value_of(Integer x, Integer y) {
    try {
      IntegerField systolic = new IntegerField(String.valueOf(x.intValue()));
      IntegerField diastolic = new IntegerField(String.valueOf(y.intValue()));
      Assertions.assertNotNull(systolic);
      Assertions.assertNotNull(diastolic);
    }
    catch (PendingException e){
      e.printStackTrace();
    }
  }

  @When("I click Calculate Button")
  public void iClickCalculateButton() {
    Button button = new Button();
    button.click();
  }

  @Then("I Verify my Blood Pressure Status as LOW")
  public void i_should_get_my_blood_pressure_status_as_low() {
    String res = BusinessLogic.checkBloodPressureStatus(70, 50);
    Assertions.assertEquals(BloodPressureConstants.LOW, res);
  }
  @Then("I Verify my Blood Pressure Status as INVALID SYSTOLIC")
  public void i_should_get_my_blood_pressure_status_as_invalid_systolic() {
    boolean res = BusinessLogic.checkSystolicisAlwaysHigherThanDiastolic(80,185);
    Assertions.assertFalse(res);
  }
  @Then("I Verify my Blood Pressure Status as HIGH")
  public void i_should_get_my_blood_pressure_status_as_high() {
    String res = BusinessLogic.checkBloodPressureStatus(140,70);
    Assertions.assertEquals(BloodPressureConstants.HIGH,res);
  }
  @Then("I Verify my Blood Pressure Status as IDEAL")
  public void i_should_get_my_blood_pressure_status_as_ideal() {
    String res = BusinessLogic.checkBloodPressureStatus(100,70);
    Assertions.assertEquals(BloodPressureConstants.IDEAL,res);
  }
  @Then("I Verify my Blood Pressure Status as PRE-HIGH")
  public void i_should_get_my_blood_pressure_status_as_pre_high() {
    String res = BusinessLogic.checkBloodPressureStatus(130,85);
    Assertions.assertEquals(BloodPressureConstants.PREHIGH,res);
  }
}
