Feature: Market import

  We need to import data describing market (odds and/or probs) in order to be able to do odds control of that market

  Scenario: Import single line market (3way)
    Given we receive single line market with identifier "591"
    And we receive probabilities for that market
      | outcomeId | probability |
      | 1         | 0.33        |
      | 2         | 0.33        |
      | 3         | 0.33        |
    When we copy all data from received single line DTO to domain object
    Then domain object should have all matching data from received single line DTO

  Scenario: Import multi line market (Totals)
    Given: we receive multi line market with identifier "161"
    And we receive probabilities for that market for typeKey "0.5"
      | outcomeId | probability |
      | 4         | 0.6         |
      | 5         | 0.4         |
    And we receive probabilities for that market for typeKey "1.5"
      | outcomeId | probability |
      | 4         | 0.4         |
      | 5         | 0.6         |
    When we copy all data from received multi line DTO to domain object
    Then domain object should have all matching data from received multi line DTO