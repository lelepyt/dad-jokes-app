package com.example.dadjokes.controller;

import com.example.dadjokes.service.JokeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/jokes")
public class JokeController {

    private final JokeService jokeService;

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @GetMapping
    public ResponseEntity<?> getJokes(@RequestParam(defaultValue = "1") int count) {
        if (count < 1 || count > 10) {
            return ResponseEntity
                    .badRequest()
                    .body("Count must be between 1 and 10");
        }
        List<String> jokes = jokeService.getJokes(count);
        return ResponseEntity.ok(jokes);
    }

}
