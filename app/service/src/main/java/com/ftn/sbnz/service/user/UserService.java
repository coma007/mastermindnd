package com.ftn.sbnz.service.user;

import com.ftn.sbnz.model.models.User;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository repository;

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public User createUser(String name) {
        User u = new User(name);
        repository.save(u);
        return u;
    }
}
