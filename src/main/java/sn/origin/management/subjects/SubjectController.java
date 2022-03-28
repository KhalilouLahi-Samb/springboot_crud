package sn.origin.management.subjects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.origin.management.users.User;
import sn.origin.management.users.UserService;

@RestController
@RequestMapping
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @Autowired
    UserService userService;

    @GetMapping("/subjects")
    public List<Subject> getAllSubjects() {

        return subjectService.getAllSubjects();
    }

    @PutMapping("/{subjectId}/users/{userId}")
    public void getEnrolledUsers(
            @PathVariable Long subjectId,
            @PathVariable Long userId) {
        Subject subject = subjectService.getASubject(subjectId);
        User user = userService.getAUser(userId);

        subject.enrollUser(user);
        subjectService.save(subject);

    }

    Subject getSubject()

}
