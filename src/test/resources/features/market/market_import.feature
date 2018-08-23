Feature: Market import

  We need to import data describing market (odds and/or probs) in order to be able to do odds control of that market

  Scenario: Import single line market (3way)
    Given we receive single line market identifier
      | marketId |
      | 591      |
    And we receive probabilities for that market
      | outcomeId | probability |
      | 1         | 0.33        |
      | 2         | 0.33        |
      | 3         | 0.33        |
    When we copy all data from received single line DTO to domain object
    Then domain object should have all matching data from received single line DTO

  Scenario: Import multi line market (Totals)
    Given: we receive multi line market identifier
      | marketId |
      | 161      |
    And we receive probabilities for that market with the corresponding typeKey
      | typeKey | outcomeId | probability |
      | 0.5     | 4         | 0.6         |
      | 0.5     | 5         | 0.4         |
      | 1.5     | 4         | 0.4         |
      | 1.5     | 5         | 0.6         |
    When we copy all data from received multi line DTO to domain object
    Then domain object should have all matching data from received multi line DTO