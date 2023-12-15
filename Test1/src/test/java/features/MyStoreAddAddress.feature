Feature: Adding a new address
  Scenario: Adding a new address for a logged-in user
    Given The user opens a browser and navigates to the MyStore page
    When The user navigates to the login page
    And The user enters valid login credentials
    And The user goes to the 'Addresses' page after logging in
    And The user clicks the '+ Create new address' button
    And The user fills out the New Address form with the following details:
    | alias | address    | city   | zip/postal code | country         | phone     |
    | mk    | Asnyka 17  | Kraków | 34-130          | Poland          | 888777666 |
    | kasm  | sasa       | sa     | 232-12          | United Kingdom  | 222       |
    And The user confirms the addition of the address
    Then The user checks if the data in the added address is correct
    And The user deletes the above address
    Then The user checks if the address has been deleted
    And The browser is closed


