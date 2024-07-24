package com.example.crudspringdata.dao.repository;

import com.example.crudspringdata.dao.entity.Teacher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {
    @Override
    List<Teacher> findAll();
    List<Teacher> findBySalaryGreaterThanEqual(BigDecimal salary);

    @Query(nativeQuery = true, value = "SELECT * FROM teachers WHERE degree=?1")
    List<Teacher> getWithDegree(String degree);

    @Query("SELECT t FROM Teacher t WHERE t.speciality =?1")
    List<Teacher> getWithSpeciality(String speciality);
}
