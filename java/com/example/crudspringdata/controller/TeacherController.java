package com.example.crudspringdata.controller;

import com.example.crudspringdata.model.enums.Degree;
import com.example.crudspringdata.model.request.CreateAndUpdateTeacherRequest;
import com.example.crudspringdata.model.response.TeacherResponse;
import com.example.crudspringdata.service.abstraction.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeacher(@RequestBody CreateAndUpdateTeacherRequest teacher) {
        teacherService.addTeacher(teacher);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TeacherResponse> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
    @GetMapping("/salary")
    @ResponseStatus(HttpStatus.OK)
    List<TeacherResponse> getTeachersBySalary(@RequestParam("salary") BigDecimal salary) {
        return teacherService.getTeacherBySalary(salary);
    }

    @GetMapping("/degree")
    List<TeacherResponse> getTeacherByDegree(@RequestParam("degree") Degree degree) {
        return teacherService.getTeacherByDegree(degree);
    }

    @GetMapping("/speciality")
    List<TeacherResponse> getTeacherBySpeciality(@RequestParam("speciality") String speciality) {
        return teacherService.getTeacherBySpeciality(speciality);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherResponse getTeacher(@PathVariable Long id) {
       return teacherService.getTeacher(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTeacher(@PathVariable Long id, @RequestBody CreateAndUpdateTeacherRequest teacher){
        teacherService.updateTeacher(id, teacher);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(Long id){
        teacherService.deleteTeacher(id);
    }

}
