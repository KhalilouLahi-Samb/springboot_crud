package sn.origin.management.subjects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    Subject getASubject(Long id) {
        return subjectRepository.getById(id);
    }

    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

}