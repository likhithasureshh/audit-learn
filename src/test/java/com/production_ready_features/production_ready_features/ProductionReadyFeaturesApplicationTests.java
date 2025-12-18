package com.production_ready_features.production_ready_features;

import com.production_ready_features.production_ready_features.RestClient.impl.RestClientImpl;
import com.production_ready_features.production_ready_features.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ProductionReadyFeaturesApplicationTests {
    @Autowired
	private RestClientImpl restClient;
	@Test
	@Order(3)
	void getAllEmployees()
	{
		List<EmployeeDTO> employeeDTOList=restClient.getAllEmployees();
		System.out.println(employeeDTOList);
	}

	@Test
	@Order(2)
	void getEmployeeById()
	{
		EmployeeDTO employeeDTO=restClient.getEmployeeById(2L);
		System.out.println(employeeDTO);
	}

	@Test
	@Order(1)
	void createNewEmployee()
	{
		EmployeeDTO employeeDTO=restClient.createNewEmployee(  new EmployeeDTO(null, "John", "john@mail.com", "DEV", 25, 50000.0,
				LocalDate.now(), true));
		System.out.println(employeeDTO);
	}

}
