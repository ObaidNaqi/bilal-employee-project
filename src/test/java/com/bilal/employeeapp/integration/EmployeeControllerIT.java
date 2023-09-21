//package com.bilal.employeeapp.integration;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.testcontainers.containers.MySQLContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.junit.jupiter.Testcontainers;
//import org.testcontainers.utility.DockerImageName;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Testcontainers
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//public class EmployeeControllerIT {
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Container
//    private static final MySQLContainer<?> mySQLContainer = new MySQLContainer<>(DockerImageName.parse("mysql:8.0.28"))
//            .withUsername("test")
//            .withPassword("test")
//            .withDatabaseName("test");
//
//    @BeforeAll
//    static void startContainers() {
//        mySQLContainer.start();
//    }
//
//    @AfterAll
//    static void stopContainers() {
//        mySQLContainer.stop();
//    }
//
//    @DynamicPropertySource
//    static void setDatasourceProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", mySQLContainer::getUsername);
//        registry.add("spring.datasource.password", mySQLContainer::getPassword);
//    }
//
//    @Test
//    public void testGetAllEmployees() {
//        // Add test data to the database if needed
//
//        // Make an HTTP GET request to your API endpoint
//        String baseUrl = "http://localhost:" + port + "/api/v1/employee/employees";
//        String response = restTemplate.getForObject(baseUrl, String.class);
//
//        // Add your assertions based on the response
//        assertEquals("Your expected response body", response);
//    }
//}
