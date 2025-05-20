package com.example.dadjokes.service;

import com.example.dadjokes.dto.JokeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JokeService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String JOKE_API_URL = "https://icanhazdadjoke.com/";

    public List<String> getJokes(int count) {
        List<String> jokes = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        for (int i = 0; i < count; i++) {
            ResponseEntity<JokeResponse> response = restTemplate.exchange(
                    JOKE_API_URL,
                    HttpMethod.GET,
                    entity,
                    JokeResponse.class
            );

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                jokes.add(response.getBody().getJoke());
            }
        }

        return jokes;
    }
}
