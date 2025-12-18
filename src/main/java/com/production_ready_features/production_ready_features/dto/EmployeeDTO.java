package com.production_ready_features.production_ready_features.dto;


import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    Long empId;

    String empName;

    String email;

    String role;
    Integer age;


    double salary;

    LocalDate doj;

    Boolean isActive;

}
