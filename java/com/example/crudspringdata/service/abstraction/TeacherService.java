package com.example.crudspringdata.service.abstraction;

import com.example.crudspringdata.dao.entity.Teacher;
import com.example.crudspringdata.model.enums.Degree;
import com.example.crudspringdata.model.request.CreateAndUpdateTeacherRequest;
import com.example.crudspringdata.model.response.TeacherResponse;

import java.math.BigDecimal;
import java.util.List;

public interface TeacherService {
    void addTeacher(CreateAndUpdateTeacherRequest teacher);
    void updateTeacher(Long id, CreateAndUpdateTeacherRequest teacher);
    void deleteTeacher(Long id);
    TeacherResponse getTeacher(Long id);
    List<TeacherResponse> getAllTeachers();
    List<TeacherResponse> getTeacherBySalary(BigDecimal salary);
    List<TeacherResponse> getTeacherByDegree(Degree degree);
    List<TeacherResponse> getTeacherBySpeciality(String speciality);
}
