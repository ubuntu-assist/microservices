package com.talanta.school;

import java.util.List;

public record FullSchoolResponse(
        String name,
        String email,
        List<Student> students
) {
}
