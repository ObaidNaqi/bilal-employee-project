package com.bilal.employeeapp.e2e;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.bilal.employeeapp.EmployeeManagementApplication;
import com.bilal.employeeapp.model.Department;
import com.bilal.employeeapp.model.Employee;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class StepDefinitions {
	
	@LocalServerPort
	private int port;
	
	
	private String baseUrl;

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;
    private Employee newEmployee = new Employee();

    @Given("the Employee Management application is running")
    public void the_employee_management_application_is_running() {
        // Set the base URL for your application
        baseUrl = "http://localhost:" + port + "/api/v1/employee";
    }

    @When("the user opens the Employee List page")
    public void the_user_opens_the_employee_list_page() {
        // Implement code to navigate to the Employee List page
        // This can include opening a web browser or making an HTTP request
    }

    @And("the user clicks on the \"Create New Employee\" button")
    public void the_user_clicks_on_create_new_employee_button() {
        // Implement code to simulate clicking on the "Create New Employee" button
        // This can include finding the button element in the HTML page and triggering a click event
    }
    
    @And("the user enter the Name {string}")
    public void the_user_enter_the_name(String ename) {
    	newEmployee.setEname(ename);
    }
    
    @And("the user enter the Age {string}")
    public void the_user_enter_the_age(String eage) {
    	newEmployee.setEage(Integer.parseInt(eage));
    }
    
    @And("the user enter the Date of Birth {string}")
    public void the_user_enter_the_date_of_birth(String edob) {
        Date dob =Date.valueOf(edob);
        newEmployee.setEdob(dob);
    }
    
    @And("the user enter the Email {string}")
    public void the_user_enter_the_email(String email) {
    	newEmployee.setEmail(email);
    }
    
    @And("the user select the department Development {string}")
    public void the_user_enter_the_department_development(String department) {
    	 newEmployee.setEdepartment(new Department(department));
    }
    
    @And("the user enter the Salary {string}")
    public void the_user_enter_the_salary(String esalary) {
    	newEmployee.setEsalary(Integer.parseInt(esalary));
    }
    

    @And("the user click the Submit button")
    public void the_user_submit_button() {
        // Implement code to simulate submitting the form with newEmployee data
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Employee> requestEntity = new HttpEntity<>(newEmployee, headers);

        response = restTemplate.exchange(baseUrl + "/employee/add", HttpMethod.POST, requestEntity, String.class);
    }

    @Then("the new employee should be added successfully")
    public void the_new_employee_should_be_added_successfully() {
        // Check the response or perform any validation to ensure the employee was added successfully
        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue());
        // You can add more assertions if needed
    }
    
    @Given("the application is running")
    public void the_application_is_running() {
    	baseUrl = "http://localhost:" + port + "/api/v1/employee";
    }

    
    @When("the user navigates to the index page")
    public void the_user_navigates_to_the_index_page() {
        // Implement the code to navigate to the index page
        // This can be done using Selenium WebDriver, RestTemplate, or other appropriate methods
        // For example, if you are using Selenium WebDriver:
        // driver.get("http://localhost:8080/index"); // Replace with your application's URL
    }

    @Then("the user should see employee data displayed")
    public void the_user_should_see_employee_data_displayed() {
        // Implement assertions to verify that employee data is displayed on the page
        // This may involve checking for specific elements or content on the page
        // For example, if you are using Selenium WebDriver:
        // WebElement employeeTable = driver.findElement(By.id("employeeTable"));
        // assertTrue(employeeTable.isDisplayed());
    }

    

}
