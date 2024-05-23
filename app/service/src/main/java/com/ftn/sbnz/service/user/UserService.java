package com.ftn.sbnz.service.user;

import com.ftn.sbnz.model.models.User;
import com.ftn.sbnz.service.kie_session.KSessionService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository repository;

    @Autowired
    private KSessionService userActivityServiceSession;

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);
        return user.orElse(null);
    }

    public User createUser(String name) {
        User u = new User(name);
        KieSession session = userActivityServiceSession.getUserActivitySession();
        session.insert(u);
        session.insert(u.getCurrentPreferences());
        session.insert(u.getHistory());
        session.insert(u.getPreference());
        session.insert(u.getWishlist());

        session.fireAllRules();
        repository.save(u);
        return u;
    }
}
