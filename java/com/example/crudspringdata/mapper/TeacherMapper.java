package com.example.crudspringdata.mapper;

import com.example.crudspringdata.dao.entity.Teacher;
import com.example.crudspringdata.model.request.CreateAndUpdateTeacherRequest;
import com.example.crudspringdata.model.response.TeacherResponse;

public enum TeacherMapper {
    TEACHER_MAPPER;
    public  Teacher mapToTeacher(CreateAndUpdateTeacherRequest teacher){
        return Teacher.builder()
                .name(teacher.getName())
                .surname(teacher.getSurname())
                .speciality(teacher.getSpeciality())
                .degree(teacher.getDegree())
                .salary(teacher.getSalary())
                .birthday(teacher.getBirthday())
                .build();
    }

    public  TeacherResponse mapToTeacherResponse(Teacher teacher){
        return TeacherResponse.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .surname(teacher.getSurname())
                .speciality(teacher.getSpeciality())
                .degree(teacher.getDegree())
                .salary(teacher.getSalary())
                .birthday(teacher.getBirthday())
                .build();
    }

    public Teacher updateTeacher(Teacher teacher, CreateAndUpdateTeacherRequest modifiedTeacher){
        if (modifiedTeacher.getName()!=null) teacher.setName(modifiedTeacher.getName());
        if (modifiedTeacher.getSurname()!=null) teacher.setSurname(modifiedTeacher.getSurname());
        if (modifiedTeacher.getSpeciality()!=null) teacher.setSpeciality(modifiedTeacher.getSpeciality());
        if (modifiedTeacher.getDegree()!=null) teacher.setDegree(modifiedTeacher.getDegree());
        if (modifiedTeacher.getSalary()!=null) teacher.setSalary(modifiedTeacher.getSalary());
        if (modifiedTeacher.getBirthday()!=null) teacher.setBirthday(modifiedTeacher.getBirthday());
        return teacher;
    }
}
