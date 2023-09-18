package com.bilal.employeeapp.ITEmployeeController;

import com.bilal.employeeapp.EmployeeManagementApplication;
import com.bilal.employeeapp.dto.DepartmentDTO;
import com.bilal.employeeapp.dto.EmployeeDTO;
import com.bilal.employeeapp.model.Department;
import com.bilal.employeeapp.model.Employee;
import com.bilal.employeeapp.service.EmployeeService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class EmployeeControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EmployeeService employeeService;

    

//    @Test
//    public void testAddEmployee() {
//    	
//    	
//        Employee employee = new Employee();
//        employee.setEname("Hassan");
//        employee.setEage(25);
//        employee.setEdob(Date.valueOf("1990-01-01"));
//        employee.setEmail("hassan@gmail.com");
//        employee.setEsalary(40000);
//        employee.setEdepartment(null);
//
//        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/employee/add", employee, String.class);
//
//     
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
//        assertNotNull(responseEntity.getBody());
//
//    }
    
    

//    @Test
//    public void testUpdateEmployee() {
//        // Create and add an employee to the database
//        EmployeeDTO employee = new EmployeeDTO();
//        employee.setEname("Hassan");
//       
//        ResponseEntity<String> status = employeeService.addEmployee(employee);
//        
//        assertEquals(HttpStatus.CREATED, status.getStatusCode());
//
//        ResponseEntity<List<EmployeeDTO>> savedEmployee = employeeService.findByName("Hassan");
//        
//        EmployeeDTO updatingEmployee = savedEmployee.getBody().get(0);
//        updatingEmployee.setEname("Ali");
//
//        restTemplate.exchange("/api/v1/employee/employee/update/{id}", 
//        		HttpMethod.PUT, new HttpEntity<>(updatingEmployee), Employee.class, updatingEmployee.getEid());
//
//        // Get the updated employee from the database
//        ResponseEntity<Employee> updatedEmployee = employeeService.getEmployeeById(updatingEmployee.getEid());
//
//        assertNotNull(updatedEmployee);
//        assertEquals("Ali", updatedEmployee.getBody().getEname());
//    }
    

//    @Test
//    public void testDeleteEmployee() {
//        // Create and add an employee to the database
//        Employee employee = new Employee();
//        employee.setEname("Hassan");
//        employee.setEage(25);
//        employee.setEdob(Date.valueOf("1990-01-01"));
//        employee.setEmail("hassan@gmail.com");
//        employee.setEsalary(40000);
//        employee.setEdepartment(new Department(2));
//        
//       
//        ResponseEntity<String> status = employeeService.addEmployee(employee);
//        
//        assertEquals(HttpStatus.CREATED, status.getStatusCode());
//
//        ResponseEntity<List<Employee>> savedEmployee = employeeService.findByName("Hassan");
//        
//        Employee existingEmployee = savedEmployee.getBody().get(0);
//
//        // Delete the employee using the API end point
//        restTemplate.delete("/api/v1/employee/employee/delete/{id}", existingEmployee.getEid());
//
//        // Try to get the deleted employee from the database
//        ResponseEntity<Employee> deletedEmployee = employeeService.getEmployeeById(existingEmployee.getEid());
//
//        
//        assertEquals(HttpStatus.NOT_FOUND, deletedEmployee.getStatusCode());
//        assertNull(deletedEmployee.getBody());
//    }
    
    @Test
    public void testGetAllEmployee() {
    	
    	  EmployeeDTO employee = new EmployeeDTO();
          employee.setEname("Hassan");
          employee.setEage(25);
          employee.setEdob(Date.valueOf("1990-01-01"));
          employee.setEmail("hassan@gmail.com");
          employee.setEsalary(40000);
          employee.setEdepartment(new DepartmentDTO(2));
          
          employeeService.addEmployee(employee);
          
	  
		  ResponseEntity<String> response = restTemplate.getForEntity("/api/v1/employee/employees", String.class);
	          
		  
		  assertEquals(HttpStatus.OK,response.getStatusCode());
          
          assertNotNull(response.getBody());
    }
    
//    @Test
//    public void testSearchByEmployeeName() {
//    	
//    	  EmployeeDTO employee1 = new EmployeeDTO(1, "Zakir", Date.valueOf("1984-01-01"), 32, "Zakir@example.com", 6000,
//  				new DepartmentDTO(2));
//          EmployeeDTO employee2 = new EmployeeDTO(1, "Bilal", Date.valueOf("1984-01-01"), 32, "bilal@example.com", 6000,
//  				new DepartmentDTO(2));
//          
//         
//          
//          employeeService.addEmployee(employee1);
//          employeeService.addEmployee(employee2);
//          
//          String nameToSearch = "Zakir";
//          
//          ParameterizedTypeReference<List<EmployeeDTO>> responseType =
//                  new ParameterizedTypeReference<List<EmployeeDTO>>() {
//                  };
//          
//          ResponseEntity<List<EmployeeDTO>> responseEntity = restTemplate.exchange(
//                  "/api/v1/employee/employees/search?name=" + nameToSearch,
//                  HttpMethod.GET,
//                  null,
//                  responseType
//                  );
//
//          
//          assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//
//       
//          List<EmployeeDTO> employees = responseEntity.getBody();
//          
//          assertNotNull(employees);
//          assertEquals(1,employees.size());
//    }
    
    
}


