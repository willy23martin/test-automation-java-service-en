package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BinaryTreeTest {

    private Car rootCar, rightCar, leftCar;

    private BinaryTree<Car> stock;

    @BeforeAll
    void setUp(){
        stock = new BinaryTree<>();
        rootCar = new Car("imageURL.jpg", "RootCar", 100.0, "Desc", "BMW");
        rightCar = new Car("imageURL.jpg", "RightCar", 200.0, "Desc", "BMW");
        leftCar = new Car("imageURL.jpg", "LeftCar", 90.0, "Desc", "BMW");
    }

    @Test
    void ARB01_isEmpty_ShouldReturnTrue_WhenItIsInitializedWithoutElements() {
        assertTrue(stock.isEmpty());
    }

    @Test
    void ARB02_isEmpty_ShouldReturnFalse_WhenItIsAtLeast1ElementInStock() {
        stock.addElement(rootCar);
        assertFalse(stock.isEmpty());
    }

    @Test
    void ARB03_addElement_AtTheFirstTime_ShouldInitializeRootCarWithTheElement() {
        BinaryTree<Car> stock = Mockito.spy(new BinaryTree<>());
        stock.addElement(rootCar);
        Mockito.verify(stock, Mockito.times(1)).setRoot(Mockito.any());
        assertEquals(stock.getRoot().getElement(), rootCar);
    }

    @Test
    void ARB04_inorder_ShouldReturnAllElementsInAscendentOrder() {
        BinaryTree<Car> stock = Mockito.spy(new BinaryTree<>());
        stock.addElement(rootCar);
        stock.addElement(rightCar);
        stock.addElement(leftCar);

        ArrayList<Car> inorder = stock.inorder();

        assertEquals(stock.getRoot().getElement(), rootCar);
        assertEquals(stock.getRoot().getRight().getElement(), rightCar);
        assertEquals(stock.getRoot().getLeft().getElement(), leftCar);
        assertEquals(inorder.get(0), leftCar);
        assertEquals(inorder.get(1), rootCar);
        assertEquals(inorder.get(2), rightCar);
    }
}