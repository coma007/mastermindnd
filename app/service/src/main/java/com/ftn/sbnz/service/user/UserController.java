package com.ftn.sbnz.service.user;

import com.ftn.sbnz.model.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserActivityService userActivityService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestParam String name) {
        User u = userService.createUser(name);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PutMapping("/save")
    public ResponseEntity<String> saveCampaign(@RequestParam Long campaignId, @RequestParam Long userId) {
        userActivityService.saveCampaign(campaignId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
