package com.production_ready_features.production_ready_features.RestClient.impl;

import com.production_ready_features.production_ready_features.RestClient.RestClientInterface;
import com.production_ready_features.production_ready_features.advices.ApiResponse;
import com.production_ready_features.production_ready_features.dto.EmployeeDTO;
import com.production_ready_features.production_ready_features.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
@Service
@RequiredArgsConstructor
public  class RestClientImpl implements RestClientInterface {
    private final RestClient restClient;
    @Override
    public List<EmployeeDTO> getAllEmployees() {
       ApiResponse<List<EmployeeDTO>> employeeDTOS=restClient.get()
               .uri("employees")
               .retrieve()
               .body(new ParameterizedTypeReference<>() {
               });
       return employeeDTOS.getData();
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        ApiResponse<EmployeeDTO> employeeDTOApiResponse=restClient.get()
                .uri("employees/{empId}",id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,(req,res)->
                {
                    System.out.println(new String(res.getBody().readAllBytes()));
                    throw  new ResourceNotFoundException("the id is not present");
                })
                .body(new ParameterizedTypeReference<>() {
                });
        return employeeDTOApiResponse.getData();
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        ApiResponse<EmployeeDTO> employeeDTOApiResponse=restClient.post()
                .uri("employees")
                .body(employeeDTO)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
        return employeeDTOApiResponse.getData();
    }
}
