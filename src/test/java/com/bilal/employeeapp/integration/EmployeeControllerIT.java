//package com.bilal.employeeapp.integration;
//
//import static org.junit.Assert.assertEquals;
//
//import java.sql.Date;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.testcontainers.containers.MySQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import com.bilal.employeeapp.dao.IEmployeeDao;
//import com.bilal.employeeapp.model.Employee;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfiguration
//@Testcontainers
//public class EmployeeControllerIT {
//
//	@LocalServerPort
//	private Integer port;
//
//	@Container
//	
//	private static final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:5.7").withDatabaseName("users")
//	            .withUsername("root").withPassword("root123").withReuse(true);
//
//	@BeforeAll
//	static void beforeAll() {
//		mysql.start();
//	}
//
//	@AfterAll
//	static void afterAll() {
//		mysql.stop();
//	}
//
//
//	@Autowired
//	IEmployeeDao employeeRepository;
//	
//	
//	  @Autowired
//	  private TestRestTemplate restTemplate;
//	
//	@Before
//	 public void setUp() {
//	   
//	    employeeRepository.deleteAll();
//	  }
//
//	  @Test
//	  public void shouldGetAllEmployees() {
//	
//	      Employee employee1 = new Employee("Ali", new Date(1999-02-12), 25, "ali@gmail.com", 20000, null);
//	      Employee employee2 = new Employee("Hassan", new Date(2000-02-12), 25, "hassan@mail.com", 20000, null);
//	  
//	    
//	      employeeRepository.save(employee1);
//	      employeeRepository.save(employee2);
//	      
//	      String url = "http://localhost:" + port + "/api/v1/employee/employees";
//	      
//	      ResponseEntity<Employee> response = restTemplate.getForEntity(url, Employee.class);
//	      
//	      assertEquals(HttpStatus.CREATED, response.getStatusCode());
//
//	 
//	  }
//	  
//	  
//	  
//	}
//	
//	
//
//
