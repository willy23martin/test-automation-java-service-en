package com.test.automation.project.testautomationjavaservicebackend.api.services;

import com.test.automation.project.testautomationjavaservicebackend.api.database.CarsDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CarsServiceTest {

    @Autowired
    private CarsDAO carsDAO;

    @Autowired
    private CarsService carsService;

    @Test
    void contextLoad_ShouldLoadAtLeasr_CarsDAO_And_CarsService(){
        assertNotNull(carsDAO);
        assertNotNull(carsService);
    }

    @Test
    void EPCARS001_getCars_ShouldReturnNine09CarsPreviouslyLoadedInCarsDAO() {
        assertEquals(9, carsService.getCars().size());
    }

    @Test
    void EPSEARCHP001_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsLessThan100Millions() {
        assertEquals(3, carsService.searchCarsByPriceRange(0.0, 100000000.0).size());
    }

    @Test
    void EPSEARCHP002_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsBetween100And200Millions() {
        assertEquals(3, carsService.searchCarsByPriceRange(100000000.0, 200000000.0).size());
    }

    @Test
    void EPSEARCHP003_searchCarsByPriceRange_ShouldReturnAListWithThree03Cars_WhenCarPriceIsGreaterThan200Millions() {
        assertEquals(3, carsService.searchCarsByPriceRange(200000000.0, 1000000000.0).size());
    }

    @Test
    void EPSEARCHP004_searchCarsByPriceRange_ShouldReturnAListWithSix06Cars_WhenCarPriceIsGreaterThan100Millions() {
        assertEquals(6, carsService.searchCarsByPriceRange(100000000.0, 1000000000.0).size());
    }

    @Test
    void EPSEARCHP005_searchCarsByPriceRange_ShouldReturnAnEmptyList_WhenCarPriceIsLessThan50Millions() {
        assertEquals(0, carsService.searchCarsByPriceRange(0.0, 50000000.0).size());
    }

    @Test
    void EPSEARCHP006_searchCarsByPriceRange_ShouldReturnAListWithNine09Cars_WhenCarPriceIsGreaterThan50Millions() {
        assertEquals(9, carsService.searchCarsByPriceRange(50000000.0, 1000000000.0).size());
    }

    @Test
    void EPSEARCHP007_searchCarsByPriceRange_ShouldThrowAnIllegalArgumentException_WhenInitialPriceIsGreaterThanTheFinalPriceOfTheFilter() {
        assertThrows(IllegalArgumentException.class, () -> {
            carsService.searchCarsByPriceRange(1000000000.0,  50000000.0);
        });

        try {
            carsService.searchCarsByPriceRange(1000000000.0,  50000000.0);
        } catch(IllegalArgumentException exception) {
            assertEquals(exception.getMessage(), "finalPrice should be greater than the initialPrice");
        }

    }

    @Test
    void EPSEARCHB001_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByBMW() {
        assertEquals(3, carsService.searchCarsByBrands("BMW").size());
    }

    @Test
    void EPSEARCHB002_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByKia() {
        assertEquals(3, carsService.searchCarsByBrands("Kia").size());
    }

    @Test
    void EPSEARCHB003_searchCarsByBrands_ShouldReturnAListWithThree03Cars_WhenFilteredByPorsche() {
        assertEquals(3, carsService.searchCarsByBrands("Porsche").size());
    }

    @Test
    void EPSEARCHB004_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByBMW_And_Kia() {
        assertEquals(6, carsService.searchCarsByBrands("BMW,Kia").size());
    }

    @Test
    void EPSEARCHB005_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByBMW_And_Porsche() {
        assertEquals(6, carsService.searchCarsByBrands("BMW,Porsche").size());
    }

    @Test
    void EPSEARCHB006_searchCarsByBrands_ShouldReturnAListWithSix06Cars_WhenFilteredByKia_And_Porsche() {
        assertEquals(6, carsService.searchCarsByBrands("Kia,Porsche").size());
    }

    @Test
    void EPSEARCHB007_searchCarsByBrands_ShouldReturnAListWithNine09Cars_WhenFilteredByBMW_And_Kia_And_Porsche() {
        assertEquals(9, carsService.searchCarsByBrands("BMW,Kia,Porsche").size());
    }

    @Test
    void searchCarsByBrands_ShouldReturnAnEmptyList_WhenNoBrandIsSpecified() {
        assertEquals(0, carsService.searchCarsByBrands("").size());
    }
}