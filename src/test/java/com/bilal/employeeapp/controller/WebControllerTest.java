package com.bilal.employeeapp.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.springframework.ui.Model;

public class WebControllerTest {

    @Test
    public void testIndexPage() {
        // Arrange
        WebController webController = new WebController();

        // Create a mock Model object
        Model model = mock(Model.class);

        // Act
        String viewName = webController.indexPage();

        // Assert
        // You can assert the view name returned by the controller
        // and any interactions with the mock Model object
        assertEquals("index", viewName);

        // Example of verifying that addAttribute was called on the Model
        verify(model, times(0)).addAttribute(anyString(), any());
    }

    @Test
    public void testCreateEmployeeForm() {
        // Arrange
        WebController webController = new WebController();

        // Act
        String viewName = webController.createEmployeeForm();

        // Assert
        // You can assert the view name returned by the controller
        assertEquals("employeeCreate", viewName);
    }
}
	
	







