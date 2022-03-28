package sn.origin.management.subjects;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import sn.origin.management.users.User;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_name", nullable = false)
    private String subjectName;

    @ManyToMany
    @JoinTable(name = "student_enrolled", joinColumns = @JoinColumn(name = "subject_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> enrolledUsers = new HashSet<>();

  
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Set<User> getEnrolledUsers() {
        return enrolledUsers;
    }
    
    public void enrollUser(User user){
        enrolledUsers.add(user);
    }

}
