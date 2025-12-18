package com.production_ready_features.production_ready_features.RestClient;

import com.production_ready_features.production_ready_features.dto.EmployeeDTO;

import java.util.List;

public interface RestClientInterface {
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO);
}
