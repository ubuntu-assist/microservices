package com.talanta.school;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface SchoolRepository extends JpaRepository<School, UUID> {
}
