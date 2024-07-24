package com.example.crudspringdata.service.concrete;

import com.example.crudspringdata.dao.entity.Teacher;
import com.example.crudspringdata.dao.repository.TeacherRepository;
import com.example.crudspringdata.exception.NotFoundException;
import com.example.crudspringdata.model.enums.Degree;
import com.example.crudspringdata.model.request.CreateAndUpdateTeacherRequest;
import com.example.crudspringdata.model.response.TeacherResponse;
import com.example.crudspringdata.service.abstraction.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


import static com.example.crudspringdata.exception.ErrorConstants.TEACHER_NOT_FOUND;
import static com.example.crudspringdata.mapper.TeacherMapper.TEACHER_MAPPER;

@Slf4j
@RequiredArgsConstructor
@Service
public class TeacherServiceHandler implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public void addTeacher(CreateAndUpdateTeacherRequest teacher) {
        teacherRepository.save(TEACHER_MAPPER.mapToTeacher(teacher));
    }

    @Override
    public void updateTeacher(Long id, CreateAndUpdateTeacherRequest teacher) {
        if (teacher==null) throw new RuntimeException();
        log.info("Updating teacher with id {}", id);
        log.info("Updating teacher with request {}", teacher);
        var teach = fetchById(id);
        log.info("write to database teacher with {}", teach);
        teacherRepository.save(TEACHER_MAPPER.updateTeacher(teach,teacher));
    }


    @Override
    public void deleteTeacher(Long id) {
        var teacher = fetchById(id);
        teacherRepository.delete(teacher);
    }

    @Override
    public TeacherResponse getTeacher(Long id) {
        var teacher = fetchById(id);
        return TEACHER_MAPPER.mapToTeacherResponse(teacher);
    }

    @Override
    public List<TeacherResponse> getAllTeachers() {
        var teachers = teacherRepository.findAll();

        return teachers.stream().map(TEACHER_MAPPER::mapToTeacherResponse).toList();
    }

    @Override
    public List<TeacherResponse> getTeacherBySalary(BigDecimal salary) {
        var teachers = teacherRepository.findBySalaryGreaterThanEqual(salary);
        return teachers.stream().map(TEACHER_MAPPER::mapToTeacherResponse).toList();
    }

    @Override
    public List<TeacherResponse> getTeacherByDegree(Degree degree) {
        var teachers = teacherRepository.getWithDegree(degree.name());
        return teachers.stream().map(TEACHER_MAPPER::mapToTeacherResponse).toList();
    }

    @Override
    public List<TeacherResponse> getTeacherBySpeciality(String speciality) {
        var teachers = teacherRepository.getWithSpeciality(speciality);
        return teachers.stream().map(TEACHER_MAPPER::mapToTeacherResponse).toList();
    }

    private  Teacher fetchById(Long id){
        return teacherRepository.findById(id).orElseThrow(()-> new NotFoundException(TEACHER_NOT_FOUND.getCode(),
                TEACHER_NOT_FOUND.getMessage()));
    }
}
