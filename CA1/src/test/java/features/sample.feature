Feature: Blood Pressure

  Scenario Outline: What is my current Blood Pressure
    Given I have entered my <systolic value> reading
    And I have also entered my <diastolic value> reading
    When I click Calculate Button
    Then I Should get my Blood Pressure Status Popped up as <status>
    Examples:
        | systolic value  | diastolic value | status |
        |   80            |      70         |   LOW  |
        |    40           |    50           |    INVALID    |


