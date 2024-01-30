# Software Testing: Final Backend Project
# Service: test-automation-java-service 

## Description:
This project aims to serve as a REST API Backend for a Car Dealership that offers the Kia, BMW and Porche brands.

****

## Objectives:
- Carry out unit and integration tests that guarantee a minimum automatic coverage of 85% in sentences and branches.
- Configure **GitHub Actions** to automate **Continuous Integration (CI)** for each new Pull Request that includes a functional change or hotfix.

****

### Technologies used:
- **Java 17** as a programming language with **maven**.
- **JUnit - Mockito**: Unit Tests.
- **Karate**: Integration Tests.
- **JaCoCo**: Code Coverage report.

****

### How to test it?

- Open the project and run ``` mvn clean install ```: verify that the **target/site/jacoco/index.html** and **target/karate-reports/karate-summary.html** files are available to review the results of component (unit) and integration tests, respectively.
- Start the project by running the command ``` mvn spring-boot:run ``` or by running the main class: [TestAutomationJavaServiceBackendApplication.java](src%2Fmain%2Fjava%2Fcom%2Ftest%2Fautomation%2Fproject%2Ftestautomationjavaservicebackend%2FTestAutomationJavaServiceBackendApplication.java )
- Create a new **Pull Request**, changing or adding some functionality with its respective unit or integration tests (folder [karate](src%2Ftest%2Fjava%2Fcom%2Ftest%2Fautomation%2Fproject%2Ftestautomationjavaservicebackend%2Fapi%2Fkarate)) and verify that the **GitHub Action - CI** has finished executing correctly by returning the statement coverage result (lines of code covered by the tests).

******

### Results:
- The results show a coverage of 85% in sentences and 75% in branches (see JaCoCo report).

![JaCoCo Report - 27102023.png](src%2Fmain%2Fresources%2FJaCoCo%20report%2FJaCoCo%20Report%20-%2027102023.png)

- Karate reports show successful integration test executions for each of the backend endpoints:
  [karate-summary.html](karate-reports%2Fkarate-summary.html)

![Karate Report - 27102023.png](src%2Fmain%2Fresources%2FKarate%20Report%2FKarate%20Report%20-%2027102023.png)

#### Endpoint: GET /api/cars:
[com.test.automation.project.testautomationjavaservicebackend.api.karate.GetCars.html](karate-reports%2Fcom.test.automation.project.testautomationjavaservicebackend.api.karate.GetCars.html)

#### Endpoint: GET api/search?initialPrice=<>&finalPrice=<>
[com.test.automation.project.testautomationjavaservicebackend.api.karate.SearchByPriceRange.html](karate-reports%2Fcom.test.automation.project.testautomationjavaservicebackend.api.karate.SearchByPriceRange.html)

#### Endpoint: GET /api/searchBrands?brands=<>,<>,<>,…
[com.test.automation.project.testautomationjavaservicebackend.api.karate.SearchByBrand.html](karate-reports%2Fcom.test.automation.project.testautomationjavaservicebackend.api.karate.SearchByBrand.html)

![Karate Report - GET Search Cars By Brand - 27102023.png](src%2Fmain%2Fresources%2FKarate%20Report%2FKarate%20Report%20-%20GET%20Search%20Cars%20By%20Brand%20-%2027102023.png)

******
******
