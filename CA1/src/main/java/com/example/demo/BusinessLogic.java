package com.example.demo;

public class BusinessLogic {

  public static boolean checkSystolicisAlwaysHigherThanDiastolic(int x, int y) {
    return x > y;
  }

  public static String checkSystolicAndDiastolicIsInAllowedRange(int x, int y) {
    if (x < BloodPressureConstants.systolicMin || x > BloodPressureConstants.systolicMax) {
      return BloodPressureConstants.INVALID_SYSTOLIC;
    }
    if (y < BloodPressureConstants.diastolicMin || y > BloodPressureConstants.diastolicMax) {
      return BloodPressureConstants.INVALID_DIASTOLIC;
    }
    return "Values are Perfect !";
  }

  public static String checkBloodPressureStatus(int x, int y){
    String bpStatus = "";
    if(checkSystolicisAlwaysHigherThanDiastolic(x ,y)) {
      if ((x >= BloodPressureConstants.systolicMin && x <= 90) && (y >= BloodPressureConstants.diastolicMin && y <= 60)) {
        bpStatus = BloodPressureConstants.LOW;
      } else if ((x > 90 && x <= 120) && (y > 60 && y <= 80)) {
        bpStatus = BloodPressureConstants.IDEAL;
      } else if ((x > 120 && x <= 140) && (y > 80 && y <= 90)) {
        bpStatus = BloodPressureConstants.PREHIGH;
      } else if ((x > 140 && x <= BloodPressureConstants.systolicMax) && (y > 90 && y <= BloodPressureConstants.diastolicMax)) {
        bpStatus = BloodPressureConstants.HIGH;
      } else {
        return checkSystolicAndDiastolicIsInAllowedRange(x, y);
      }
    } else {
      return "Enter Values Again";
    }
    return bpStatus;
  }
}
