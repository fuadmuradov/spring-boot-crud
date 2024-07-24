package com.example.crudspringdata.model.request;

import com.example.crudspringdata.model.enums.Degree;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAndUpdateTeacherRequest {
    private String name;
    private String surname;
    private String speciality;
    private Degree degree;
    private BigDecimal salary;
    private LocalDateTime birthday;
}
