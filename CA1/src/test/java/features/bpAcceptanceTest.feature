Feature: Blood Pressure

  Scenario Outline: What is my current Blood Pressure
    Given I am on BP calculate home page
    And I have entered my Systolic value of <systolic value> and my Diastolic value of <diastolic value>
    When I click Calculate Button
    Then I Verify my Blood Pressure Status as <status>
    Examples:
        | systolic value  | diastolic value | status |
        |   70            |      50         |   LOW  |
        |    40           |    50           |  INVALID SYSTOLIC    |
        |   100           |      70         |   IDEAL  |
        |   140           |      60         |   HIGH  |
        |   130           |      85         |   PRE-HIGH  |


