package sn.origin.management.users;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> allUsers() {
        return repository.findAll();
    }

    public void save(User user) {
        repository.save(user);
    }

    public User getAUser(Long id) {

        return repository.getById(id);
    }

}
