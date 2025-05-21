package com.talanta.school;

import com.talanta.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void createSchool(School student) {
        schoolRepository.save(student);
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse getSchoolWithStudents(UUID schoolId) {
        School school = schoolRepository.findById(schoolId)
                .orElse(School.builder()
                        .name("Not Found")
                        .email("Not Found")
                        .build()
                );

        List<Student> students = studentClient.getAllStudentsBySchool(schoolId);

        return new FullSchoolResponse(
               school.getName(),
               school.getEmail(),
               students
        );
    }
}
