package dev.lydtech.service;

import dev.lydtech.domain.Mood;
import dev.lydtech.properties.ThirdPartyProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserMoodService {

    @Autowired
    private ThirdPartyProperties properties;

    public void processUserMood(Mood mood) {
        if (mood == Mood.GRUMPY || mood == Mood.HAPPY ) {
            callThirdparty(mood.toString());
        }
    }

    private void callThirdparty(String mood) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(properties.getEndpoint() + mood, String.class);
        if (!response.getStatusCode().equals(HttpStatus.OK)) {
            throw new RuntimeException("Error: " + response.getStatusCode());
        }
    }
}
