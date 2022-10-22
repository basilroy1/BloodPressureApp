package com.example.demo;

public class BusinessLogic {
  public BusinessLogic(){}
  public static boolean checkSystolicisAlwaysHigherThanDiastolic(int x, int y) {
    return x > y;
  }

  public static String checkSystolicAndDiastolicIsInAllowedRange(int x, int y) {
    if ((x < BloodPressureConstants.SYSTOLIC_MIN) || (x > BloodPressureConstants.SYSTOLIC_MAX)) {
      return BloodPressureConstants.INVALID_SYSTOLIC;
    } else if ((y < BloodPressureConstants.DIASTOLIC_MIN) || (y > BloodPressureConstants.DIASTOLIC_MAX)) {
      return BloodPressureConstants.INVALID_DIASTOLIC;
    }
    return "Values are In-Range !";
  }
  public static String checkBloodPressureStatus(int x, int y){
    String bpStatus = "";
    if(checkSystolicAndDiastolicIsInAllowedRange(x,y).equals("Values are In-Range !")){
      if(checkSystolicisAlwaysHigherThanDiastolic(x,y)) {
        //low
        if ((x >= BloodPressureConstants.SYSTOLIC_MIN && x <= 89) && (y >= BloodPressureConstants.DIASTOLIC_MIN && y <= 59)) {
          bpStatus = BloodPressureConstants.LOW;
        } else if ((x >= BloodPressureConstants.SYSTOLIC_MIN && x <= 89) && (y >= 60 && y <= 79)) {
          bpStatus = BloodPressureConstants.IDEAL;
        } else if ((x >= BloodPressureConstants.SYSTOLIC_MIN && x <= 89) && (y >= 80 && y <= 88)) {
          bpStatus = BloodPressureConstants.PREHIGH;  //CANT PUT 89 HERE need to check for greater than systolic value
        }
        //ideal
          else if ((x >= 90 && x <= 119) && (y >= BloodPressureConstants.DIASTOLIC_MIN && y <= 59)) {
          bpStatus = BloodPressureConstants.IDEAL;
        } else if ((x >= 90 && x <= 119) && (y >= 60 && y <= 79)) {
          bpStatus = BloodPressureConstants.IDEAL;
        } else if ((x >= 90 && x <= 119) && (y >= 80 && y <= 89)) {
          bpStatus = BloodPressureConstants.PREHIGH;
        } else if ((x >= 90 && x <= 119) && (y >= 90 && y <= BloodPressureConstants.DIASTOLIC_MAX)) {
          bpStatus = BloodPressureConstants.HIGH;
        }
        //prehigh
        else if ((x >= 120 && x <= 139) && (y >= BloodPressureConstants.DIASTOLIC_MIN && y <= 59)) {
          bpStatus = BloodPressureConstants.PREHIGH;
        } else if ((x >= 120 && x <= 139) && (y >= 80 && y <= 89)) {
          bpStatus = BloodPressureConstants.PREHIGH;
        } else if ((x >= 120 && x <= 139) && (y >= 90 && y <= BloodPressureConstants.DIASTOLIC_MAX)) {
          bpStatus = BloodPressureConstants.HIGH;
        }
        //high
        else if ((x >= 140 && x <= BloodPressureConstants.SYSTOLIC_MAX)) {
          bpStatus = BloodPressureConstants.HIGH;
        }
      } else {
        return "Systolic Value must be greater than Diastolic";
      }
    } else {
      return checkSystolicAndDiastolicIsInAllowedRange(x, y);
    }
    return bpStatus;
  }
}
