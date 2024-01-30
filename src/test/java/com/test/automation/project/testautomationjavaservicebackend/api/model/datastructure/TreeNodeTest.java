package com.test.automation.project.testautomationjavaservicebackend.api.model.datastructure;

import com.test.automation.project.testautomationjavaservicebackend.api.model.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TreeNodeTest {

    private TreeNode<Car> rootTreeNode, rightTreeNode;
    private Car rootCar, rightCar;

    @BeforeAll
    void setUp(){
        rootCar = new Car("imageURL.jpg", "RootCar", 100.00, "Desc", "BMW");
        rightCar = new Car("imageURL.jpg", "RightCar", 200.0, "Desc", "BMW");
        rootTreeNode = new TreeNode<>(rootCar);
        rightTreeNode = new TreeNode<>(rightCar);
    }

    @Test
    void NODAB01_ToString_ShouldReturnRootCarStringRepresentation() {
        assertEquals(rootTreeNode.toString(), rootCar.toString());
    }

    @Test
    void NODAB02_Equals_ShouldReturnFalse_WhenCarPricesAreDifferent() {
        assertFalse(rootTreeNode.equals(rightTreeNode));
    }

    @Test
    void NODAB03_Equals_ShouldReturnTrue_WhenCarPricesAreEqual() {
        TreeNode<Car> treeNode = new TreeNode<>(rightCar);
        assertTrue(rightTreeNode.equals(treeNode));
    }

}