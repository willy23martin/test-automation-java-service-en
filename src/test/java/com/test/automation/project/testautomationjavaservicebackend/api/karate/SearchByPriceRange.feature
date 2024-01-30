Feature: GET Search Cars By Price Range

  Scenario: EPSEARCHP001_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsLessThan100Millions
    Given url baseUrl + '/api/search'
    And param initialPrice = 0.0
    And param finalPrice = 100000000.0
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: EPSEARCHP002_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsBetween100And200Millions
    Given url baseUrl + '/api/search'
    And param initialPrice = 100000000.0
    And param finalPrice = 200000000.0
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: EPSEARCHP003_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsGreaterThan200Millions
    Given url baseUrl + '/api/search'
    And param initialPrice = 200000000.0
    And param finalPrice = 1000000000.0
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: EPSEARCHP004_searchCarsByPriceRange_ShouldReturnAListWithSix06Cars_WhenCarPriceIsGreaterThan100Millions
    Given url baseUrl + '/api/search'
    And param initialPrice = 100000000.0
    And param finalPrice = 1000000000.0
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: EPSEARCHP005_searchCarsByPriceRange_ShouldReturnAnEmptyList_WhenCarPriceIsLessThan50Millions
    Given url baseUrl + '/api/search'
    And param initialPrice = 0.0
    And param finalPrice = 50000000.0
    When method get
    Then status 200
    And match response == '#[0]'

  Scenario: EPSEARCHP006_searchCarsByPriceRange_ShouldReturnAListWithNine09Cars_WhenCarPriceIsGreaterThan50Millions
    Given url baseUrl + '/api/search'
    And param initialPrice = 50000000.0
    And param finalPrice = 1000000000.0
    When method get
    Then status 200
    And match response == '#[9]'

  Scenario: EPSEARCHP007_searchCarsByPriceRange_ShouldThrowAnIllegalArgumentException_WhenInitialPriceIsGreaterThanTheFinalPriceOfTheFilter
    Given url baseUrl + '/api/search'
    And param initialPrice = 1000000000.0
    And param finalPrice = 50000000.0
    When method get
    Then status 400
    And match karate.toString(response) contains "Bad Request"