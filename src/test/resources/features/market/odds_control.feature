Feature: Odds control

  We have to be able to adjust market outcomes

  Scenario: Manually adjust outcome value
    Given we have single line market (3way) with identifier "591"
    And we have following odds for outcomes for that market
      | outcome | odds |
      | HOME    | 1.10 |
      | DRAW    | 2.24 |
      | AWAY    | 7.55 |
    When we change DRAW outcome value to 3.45
    Then other two outcomes should be adjusted to following values
      | outcome | odds |
      | HOME    | 1.15 |
      | AWAY    | 10.2 |
