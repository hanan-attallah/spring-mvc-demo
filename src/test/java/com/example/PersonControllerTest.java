package com.example;

import com.example.controller.PersonController;
import com.example.model.Address;
import com.example.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.*;

public class PersonControllerTest {
    @Test
    public void testShowPersonForm() {
        // Arrange
        PersonController controller = new PersonController();
        ModelMap model = new ModelMap();

        // Act
        String viewName = controller.showPersonForm(model);

        // Assert
        assertEquals("person_form", viewName); // Check if the correct view name is returned
        assertNotNull(model.get("person")); // Check if a Person object is added to the model
    }

    @Test
    public void testSubmitPersonForm_SuccessfulSubmission() {
        // Arrange
        PersonController controller = new PersonController();
        ModelMap model = new ModelMap();
        Person person = new Person();
        person.setName("John");
        person.setAge(30);
        Address address = new Address();
        address.setCity("New York");
        address.setCountry("USA");
        person.setAddress(address);

        // Act
        String viewName = controller.submitPersonForm(person, model);

        // Assert
        assertEquals("person_details", viewName); // Check if the correct view name is returned
        assertEquals("John", model.get("name")); // Check if name attribute is added to the model
        assertEquals(30, model.get("age")); // Check if age attribute is added to the model
        assertEquals("New York", model.get("city")); // Check if city attribute is added to the model
        assertEquals("USA", model.get("country")); // Check if country attribute is added to the model
    }

    @Test
    public void testSubmitPersonForm_NullAddress() {
        // Arrange
        PersonController controller = new PersonController();
        ModelMap model = new ModelMap();
        Person person = new Person();
        person.setName("John");
        person.setAge(30);

        // Act
        String viewName = controller.submitPersonForm(person, model);

        // Assert
        assertEquals("person_details", viewName); // Check if the correct view name is returned
        assertEquals("John", model.get("name")); // Check if name attribute is added to the model
        assertEquals(30, model.get("age")); // Check if age attribute is added to the model
        assertEquals("Unknown", model.get("city")); // Check if city attribute is set to "Unknown"
        assertEquals("Unknown", model.get("country")); // Check if country attribute is set to "Unknown"
    }


}
