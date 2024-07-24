package com.example.crudspringdata.model.response;

import com.example.crudspringdata.model.enums.Degree;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TeacherResponse {
    Long id;
    String name;
    String surname;
    String speciality;
    Degree degree;
    BigDecimal salary;
    LocalDateTime birthday;
}
