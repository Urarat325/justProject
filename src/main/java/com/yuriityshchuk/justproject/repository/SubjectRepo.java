package com.yuriityshchuk.justproject.repository;

import com.yuriityshchuk.justproject.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    Subject findBySubject(String subject);
}
