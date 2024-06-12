package com.ftn.sbnz.service.user;

import com.ftn.sbnz.model.models.Campaign;
import com.ftn.sbnz.model.models.Credentials;
import com.ftn.sbnz.model.models.SearchData;
import com.ftn.sbnz.model.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserActivityService userActivityService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Credentials credentials) {
        User user = userService.login(credentials.username, credentials.password);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestParam String username, String password) {
        User u = userService.createUser(username, password);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PutMapping("/save")
    public ResponseEntity<String> saveCampaign(@RequestParam Long campaignId, @RequestParam Long userId) {
        userActivityService.saveCampaign(campaignId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/like")
    public ResponseEntity<String> likeCampaign(@RequestParam Long campaignId, @RequestParam Long userId) {
        userActivityService.likeCampaign(campaignId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/play")
    public ResponseEntity<String> playCampaign(@RequestParam Long campaignId, @RequestParam Long userId) {
        userActivityService.playCampaign(campaignId, userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/campaigns")
    public ResponseEntity<List<Campaign>> getCampaigns(@RequestParam String type, @RequestParam Long userId) {
        List<Campaign> campaigns = userActivityService.getCampaigns(type, userId);
        campaigns = new ArrayList<>(new HashSet<>(campaigns));
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Campaign>> searchCampaigns(@RequestBody SearchData data, @RequestParam Long userId) {
        List<Campaign> campaigns = userActivityService.searchCampaigns(data, userId);
        campaigns = new ArrayList<>(new HashSet<>(campaigns));
        return new ResponseEntity<>(campaigns, HttpStatus.OK);
    }
}
