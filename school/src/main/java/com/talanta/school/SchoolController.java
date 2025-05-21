package com.talanta.school;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @GetMapping
    public ResponseEntity<List<School>> getAllSchools() {
        return ResponseEntity.ok(schoolService.getAllSchools());
    }

    @GetMapping("with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> getAllSchoolWithStudents(@PathVariable("school-id") UUID schoolId) {
        return ResponseEntity.ok(schoolService.getSchoolWithStudents(schoolId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSchool(@RequestBody School student) {
        schoolService.createSchool(student);
    }
}
