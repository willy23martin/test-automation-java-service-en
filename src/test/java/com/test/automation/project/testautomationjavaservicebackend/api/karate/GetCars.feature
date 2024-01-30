Feature: GET Cars API returns nine cars

  Scenario: EPCARS001 the inventory contains a list of nine preloaded cars
    Given url baseUrl + '/api/cars'
    When method get
    Then status 200
    And match response == '#[9]'
