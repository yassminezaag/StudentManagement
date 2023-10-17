package com.yass.studentmangament.services;

import com.yass.studentmangament.entities.Subject;

import java.util.List;

public interface ISubjectService {
    public Subject createSubject(Subject subject);
    public List<Subject> getAllSubjects();
    public void deleteSubjectById(Long id);
}
