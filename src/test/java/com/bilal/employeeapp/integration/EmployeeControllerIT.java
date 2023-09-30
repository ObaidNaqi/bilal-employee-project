//package com.bilal.employeeapp.integration;
//
//
//
//import org.junit.AfterClass;
//import org.junit.BeforeClass;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
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
//import com.bilal.employeeapp.dto.DepartmentDTO;
//import com.bilal.employeeapp.dto.EmployeeDTO;
//
//
//import java.sql.Date;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//@Testcontainers
//public class EmployeeControllerIT {
//
//    @Container
//    private static final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:5.7").withDatabaseName("mydb")
//            .withUsername("root").withPassword("password").withReuse(true);
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private IEmployeeDao employeeDao;
//
//    @Before
//    public void setUp() {
//        employeeDao.deleteAll();
//    }
//
//    @BeforeClass
//    public static void beforeAll() {
//        mysql.start();
//    }
//
//    @AfterClass
//    public static void afterAll() {
//        mysql.stop();
//    }
//
//    @Test
//    public void testAddEmployee() {
//        // Arrange
//       EmployeeDTO employee = new EmployeeDTO();
//       employee.setEname("Hassan");
//       employee.setEage(25);
//       employee.setEdob(Date.valueOf("1990-01-01"));
//       employee.setEmail("hassan@gmail.com");
//       employee.setEsalary(40000);
//       employee.setEdepartment(new DepartmentDTO(2));
//
//        String url = "http://localhost:" + port + "/api/v1/employee/employee/add";
//
//        // Act
//        ResponseEntity<EmployeeDTO> response = restTemplate.postForEntity(url, employee, EmployeeDTO.class);
//
//        System.out.println("response = "+response);
//      
//    }
//
//   
//
//   
//}