package dev.lydtech.controller;

import dev.lydtech.domain.Mood;
import dev.lydtech.service.UserMoodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserMoodService userMoodService;

    @PutMapping("/users/{id}/mood/{mood}")
    public Mood updateUserMood(@PathVariable Mood mood, @PathVariable Long id) {
        userMoodService.processUserMood(mood);
        return mood;
    }

}
