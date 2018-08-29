Feature: Key control

  We must have option to adjust key for complete market and that should change odds accordingly

  Scenario: Adjust key for single line market
    Given single line market with identifier "591"
    And following odds for outcomes for that market
      | outcome | value |
      | HOME    | 1.10  |
      | DRAW    | 2.24  |
      | AWAY    | 7.55  |
    When we adjust key value to "125"
    Then all odds should update to following values
      | outcome | value   |
      | HOME    | 137.5   |
      | DRAW    | 280.0   |
      | AWAY    | 943.75  |

  Scenario: Adjust key for one typeKey in multi line market
    Given multi line market with identifier "161"
    And following odds for outcomes for typeKey "0.5" for that market
      | outcome | value |
      | OVER    | 1.10  |
      | UNDER   | 2.24  |
    And following odds for outcomes for typeKey "1.5" for that market
      | outcome | value |
      | OVER    | 1.10  |
      | UNDER   | 2.24  |
    When we adjust key value to "125" for typeKey "0.5" in that market
    Then odds for typeKey "0.5" should be adjusted to following values
      | outcome | value |
      | OVER    | 1.10  |
      | UNDER   | 2.24  |
    But odds for other typeKey should be unchanged
