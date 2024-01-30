Feature: GET Search Cars By Brand

  Scenario: EPSEARCHB001_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByBMW
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW'
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: EPSEARCHB002_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByKia
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'Kia'
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: EPSEARCHB003_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByPorsche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'Porsche'
    When method get
    Then status 200
    And match response == '#[3]'

  Scenario: EPSEARCHB004_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByBMW_And_Kia
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW,Kia'
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: EPSEARCHB005_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByBMW_And_Porsche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW,Porsche'
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: EPSEARCHB006_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByKia_And_Porsche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'Kia,Porsche'
    When method get
    Then status 200
    And match response == '#[6]'

  Scenario: EPSEARCHB007_searchCarsByBrands_ShouldReturnAListWithNine09Cars_WhenFilteredByBMW_And_Kia_And_Porsche
    Given url baseUrl + '/api/searchBrands'
    And param brands = 'BMW,Kia,Porsche'
    When method get
    Then status 200
    And match response == '#[9]'

  Scenario: EPSEARCHB008_searchCarsByBrands_ShouldReturnAListWithNine09Cars_WhenNoBrandIsSpecified
    Given url baseUrl + '/api/searchBrands'
    And param brands = ''
    When method get
    Then status 200
    And match response == '#[9]'

  Scenario: EPSEARCHB009_searchCarsByBrands_ShouldReturnAListWithNine09Cars_WhenBrandsParamIsNotDefined
    Given url baseUrl + '/api/searchBrands'
    When method get
    Then status 200
    And match response == '#[9]'