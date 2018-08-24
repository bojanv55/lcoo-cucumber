Feature: Key control

  We must have option to adjust key for complete market and that should change odds accordingly

  Scenario: Adjust key for single line market
    Given we have single line market (3way) with identifier "591"
    And we have following odds for outcomes for that market
      | outcome | odds |
      | HOME    | 1.10 |
      | DRAW    | 2.24 |
      | AWAY    | 7.55 |
    When we adjust key value to "125"
    Then all odds should update to following values
      | outcome | odds |
      | HOME    | 2.00 |
      | DRAW    | 4.00 |
      | AWAY    | 8.00 |
