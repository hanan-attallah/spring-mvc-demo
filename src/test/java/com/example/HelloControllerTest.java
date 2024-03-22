package com.example;

import com.example.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloControllerTest {

    @Test
    public void testPrintHelloWorld() {
        // Arrange
        HelloController controller = new HelloController();
        ModelMap modelMap = new ModelMap();

        // Act
        String viewName = controller.printHelloWorld(modelMap);

        // Assert
        assertEquals("hello", viewName); // Check if the correct view name is returned
        assertEquals("Hello! Today is March 22, 2024.", modelMap.get("message")); // Check if the message attribute is added
    }

    @Test
    public void testHandleNullModelMap() {
        // Arrange
        HelloController controller = new HelloController();

        // Act
        String viewName = controller.printHelloWorld(null);

        // Assert
        assertEquals("hello", viewName); // Check if the correct view name is returned
        // Add more assertions if necessary
    }

}
