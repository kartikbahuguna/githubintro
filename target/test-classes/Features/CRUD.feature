@smoke
Feature: Test CRUD methods in Sample Employee REST API testing

  @smokeOne
  Scenario Outline: Add Employee record
    Given I set POST employee service api endpoint and <file_loc>
    And I create a request and enter <name> and <job>
    When I pass the request and <endpointUri>
    Then I check the reponse by <statuscode>

    Examples: 
      | name   | job      | endpointUri | statuscode | file_loc                                                                                                           |
      | Kartik | Engineer | /api/users  |        201 | C:\\Users\\Kartik.Bahuguna\\eclipse-workspace\\com.restAssured\\src\\test\\java\\StepDefinition\\config.properties |

  @smokeTwo
  Scenario Outline: UPDATE Employee record
    Given I set PUT employee service api endpoint and <file_loc>
    And I create a put request and enter updated <name> and <job>
    When I pass the put request and <endpointUri>
    Then I check the put response by <statuscode>

    Examples: 
      | name   | job               | endpointUri  | statuscode | file_loc                                                                                                           |
      | Somesh | Software Engineer | /api/users/2 |        200 | C:\\Users\\Kartik.Bahuguna\\eclipse-workspace\\com.restAssured\\src\\test\\java\\StepDefinition\\config.properties |

  @smokeFour
  Scenario Outline: GET Employee record
    Given I set GET employee service api endpoints and <file_loc>
    When I create a get request and pass the <endpointUri>
    Then I check the get response by <statuscode>

    Examples: 
      | endpointUri  | statuscode | file_loc                                                                                                           |
      | /api/users/2 |        200 | C:\\Users\\Kartik.Bahuguna\\eclipse-workspace\\com.restAssured\\src\\test\\java\\StepDefinition\\config.properties |

  @smokeThree
  Scenario Outline: DELETE Employee record
    Given I set DELETE employee service api endpoint and <file_loc>
    When I create DELETE HTTP request and pass the <endpointUri>
    Then I check the DELETE response by <statuscode>

    Examples: 
      | endpointUri  | statuscode | file_loc                                                                                                           |
      | /api/users/2 |        204 | C:\\Users\\Kartik.Bahuguna\\eclipse-workspace\\com.restAssured\\src\\test\\java\\StepDefinition\\config.properties |
