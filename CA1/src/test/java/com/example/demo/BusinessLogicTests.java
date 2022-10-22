package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class BusinessLogicTests {
  @InjectMocks
  private BusinessLogic businessLogic;

  @Test
  void checkifSystolicisGreater(){
    Assertions.assertTrue(BusinessLogic.checkSystolicisAlwaysHigherThanDiastolic(90,80));
  }
  @Test
  void checkifSystolicisLessThanDiastolic(){
    Assertions.assertFalse(BusinessLogic.checkSystolicisAlwaysHigherThanDiastolic(80,90));
  }
  @Test
  void checkInValidSystolicRange(){
    String res = BusinessLogic.checkSystolicAndDiastolicIsInAllowedRange(10,40);
    Assertions.assertEquals(BloodPressureConstants.INVALID_SYSTOLIC,res);
  }
  @Test
  void checkInValidSystolicRange2(){
    String res = BusinessLogic.checkSystolicAndDiastolicIsInAllowedRange(200,80);
    Assertions.assertEquals(BloodPressureConstants.INVALID_SYSTOLIC,res);
  }
  @Test
  void checkInValidDiastolicRange(){
    String res = BusinessLogic.checkSystolicAndDiastolicIsInAllowedRange(75,130);
    Assertions.assertEquals(BloodPressureConstants.INVALID_DIASTOLIC,res);
  }
  @Test
  void checkInValidDiastolicRange2(){
    String res = BusinessLogic.checkSystolicAndDiastolicIsInAllowedRange(75,30);
    Assertions.assertEquals(BloodPressureConstants.INVALID_DIASTOLIC,res);
  }
  @Test
  void checkValidDiastolicandSystolicRange(){
    String res = BusinessLogic.checkSystolicAndDiastolicIsInAllowedRange(75,90);
    Assertions.assertEquals("Values are In-Range !",res);
  }
  @Test
  void checkBPStatusisLOW(){
    String res = BusinessLogic.checkBloodPressureStatus(80,50);
    Assertions.assertEquals(BloodPressureConstants.LOW,res);
  }
  @Test
  void checkBPStatusisIDEAL(){
    String res = BusinessLogic.checkBloodPressureStatus(110,75);
    Assertions.assertEquals(BloodPressureConstants.IDEAL,res);
  }
  @Test
  void checkBPStatusisIDEAL2(){
    String res = BusinessLogic.checkBloodPressureStatus(88,75);
    Assertions.assertEquals(BloodPressureConstants.IDEAL,res);
  }
  @Test
  void checkBPStatusisIDEAL3(){
    String res = BusinessLogic.checkBloodPressureStatus(115,55);
    Assertions.assertEquals(BloodPressureConstants.IDEAL,res);
  }
  @Test
  void checkBPStatusisPREHIGH(){
    String res = BusinessLogic.checkBloodPressureStatus(130,85);
    Assertions.assertEquals(BloodPressureConstants.PREHIGH,res);
  }
  @Test
  void checkBPStatusisPREHIGH2(){
    String res = BusinessLogic.checkBloodPressureStatus(88,87);
    Assertions.assertEquals(BloodPressureConstants.PREHIGH,res);
  }
  @Test
  void checkBPStatusisPREHIGH3(){
    String res = BusinessLogic.checkBloodPressureStatus(111,85);
    Assertions.assertEquals(BloodPressureConstants.PREHIGH,res);
  }
  @Test
  void checkBPStatusisPREHIGH4(){
    String res = BusinessLogic.checkBloodPressureStatus(122,55);
    Assertions.assertEquals(BloodPressureConstants.PREHIGH,res);
  }
  @Test
  void checkBPStatusisHIGH(){
    String res = BusinessLogic.checkBloodPressureStatus(150,95);
    Assertions.assertEquals(BloodPressureConstants.HIGH,res);

  }
  @Test
  void checkBPStatusisHIGH4(){
    String res2 = BusinessLogic.checkBloodPressureStatus(110,95);
    Assertions.assertEquals(BloodPressureConstants.HIGH,res2);
  }
  @Test
  void checkBPStatusisHIGH5(){
    String res3 = BusinessLogic.checkBloodPressureStatus(123,95);
    Assertions.assertEquals(BloodPressureConstants.HIGH,res3);
  }
  @Test
  void checkBPStatusIncorrectData(){
    String res = BusinessLogic.checkBloodPressureStatus(80,95);
    Assertions.assertEquals("Systolic Value must be greater than Diastolic",res);
  }
}
