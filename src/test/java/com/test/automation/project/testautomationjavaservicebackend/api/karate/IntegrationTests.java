package com.test.automation.project.testautomationjavaservicebackend.api.karate;

import com.intuit.karate.junit5.Karate;
import com.test.automation.project.testautomationjavaservicebackend.TestAutomationJavaServiceBackendApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(
        classes = TestAutomationJavaServiceBackendApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class IntegrationTests {

    @LocalServerPort
    private String localServerPort;

    @Karate.Test
    public Karate EPCARS001_TheInventoryContainsAListOfNinePreloadedCars() {
        return karateScenario("EPCARS001 the inventory contains a list of nine preloaded cars");
    }

    @Karate.Test
    public Karate EPSEARCHP001_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsLessThan100Millions(){
        return karateScenario("EPSEARCHP001_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsLessThan100Millions");
    }

    @Karate.Test
    public Karate EPSEARCHP002_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsBetween100And200Millions(){
        return karateScenario("EPSEARCHP002_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsBetween100And200Millions");
    }

     @Karate.Test
     public Karate EPSEARCHP003_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsGreaterThan200Millions(){
        return karateScenario("EPSEARCHP003_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsGreaterThan200Millions");
     }

     @Karate.Test
     public Karate EPSEARCHP004_searchCarsByPriceRange_ShouldReturnAListWithSix06Cars_WhenCarPriceIsGreaterThan100Millions(){
        return karateScenario("EPSEARCHP004_searchCarsByPriceRange_ShouldReturnAListWithSix06Cars_WhenCarPriceIsGreaterThan100Millions");
     }

     @Karate.Test
     public Karate EPSEARCHP005_searchCarsByPriceRange_ShouldReturnAnEmptyList_WhenCarPriceIsLessThan50Millions(){
        return karateScenario("EPSEARCHP005_searchCarsByPriceRange_ShouldReturnAnEmptyList_WhenCarPriceIsLessThan50Millions");
     }

     @Karate.Test
     public Karate EPSEARCHP006_searchCarsByPriceRange_ShouldReturnAListWithNine09Cars_WhenCarPriceIsGreaterThan50Millions(){
        return karateScenario("EPSEARCHP006_searchCarsByPriceRange_ShouldReturnAListWithNine09Cars_WhenCarPriceIsGreaterThan50Millions");
     }

     @Karate.Test
     public Karate EPSEARCHP007_searchCarsByPriceRange_ShouldThrowAnIllegalArgumentException_WhenInitialPriceIsGreaterThanTheFinalPriceOfTheFilter(){
        return karateScenario("EPSEARCHP007_searchCarsByPriceRange_ShouldThrowAnIllegalArgumentException_WhenInitialPriceIsGreaterThanTheFinalPriceOfTheFilter");
     }

    @Karate.Test
    public Karate EPSEARCHB001_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByBMW(){
        return karateScenario("EPSEARCHB001_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByBMW");
    }

    @Karate.Test
    public Karate EPSEARCHB002_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByKia(){
        return karateScenario("EPSEARCHB002_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByKia");
    }

    @Karate.Test
    public Karate EPSEARCHB003_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByPorsche(){
        return karateScenario("EPSEARCHB003_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByPorsche");
    }

    @Karate.Test
    public Karate EPSEARCHB004_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByBMW_And_Kia(){
        return karateScenario("EPSEARCHB004_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByBMW_And_Kia");
    }

    @Karate.Test
    public Karate EPSEARCHB005_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByBMW_And_Porsche(){
        return karateScenario("EPSEARCHB005_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByBMW_And_Porsche");
    }

    @Karate.Test
    public Karate EPSEARCHB006_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByKia_And_Porsche(){
        return karateScenario("EPSEARCHB006_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByKia_And_Porsche");
    }

    @Karate.Test
    public Karate EPSEARCHB007_searchCarsByBrands_ShouldReturnAListWithNine09Cars_WhenFilteredByBMW_And_Kia_And_Porsche(){
        return karateScenario("EPSEARCHB007_searchCarsByBrands_ShouldReturnAListWithNine09Cars_WhenFilteredByBMW_And_Kia_And_Porsche");
    }

    @Karate.Test
    public Karate EPSEARCHB008_searchCarsByBrands_ShouldReturnAListWithNine09Cars_WhenNoBrandIsSpecified(){
        return karateScenario("EPSEARCHB008_searchCarsByBrands_ShouldReturnAListWithNine09Cars_WhenNoBrandIsSpecified");
    }

    @Karate.Test
    public Karate EPSEARCHB009_searchCarsByBrands_ShouldReturnAListWithNine09Cars_WhenBrandsParamIsNotDefined(){
        return karateScenario("EPSEARCHB009_searchCarsByBrands_ShouldReturnAListWithNine09Cars_WhenBrandsParamIsNotDefined");
    }

    private Karate karateScenario(String scenarioName) {
        return Karate.run()
                .scenarioName(scenarioName)
                .relativeTo(getClass())
                .systemProperty("karate.port", localServerPort)
                .karateEnv("dev");
    }

}
