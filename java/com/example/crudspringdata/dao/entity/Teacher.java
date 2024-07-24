package com.example.crudspringdata.dao.entity;

import com.example.crudspringdata.model.enums.Degree;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teachers")
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String speciality;
    @Enumerated(EnumType.STRING)
    Degree degree;
    BigDecimal salary;
    LocalDateTime birthday;
}
