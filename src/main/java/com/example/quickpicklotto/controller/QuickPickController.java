package com.example.quickpicklotto.controller;

import com.example.quickpicklotto.service.QuickPickService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(value = "/quickpick", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuickPickController {

    QuickPickService quickPickService = new QuickPickService();
    public static final int MIN_NUMBER_OF_GAMES = 4;
    public static final int MAX_NUMBER_OF_GAMES = 50;
    public static final String WELCOME_MESSAGE = "Welcome to Quick Pick Lottery! View README.md in repository for instructions.";

    @GetMapping
    public Map<String, String> getQuickPick() {
        return Collections.singletonMap("response", WELCOME_MESSAGE);
    }

    @GetMapping("/{noOfGames}")
    public Object getQuickPick(@PathVariable Long noOfGames) {
        if(noOfGames < MIN_NUMBER_OF_GAMES || noOfGames > MAX_NUMBER_OF_GAMES) {
            return Collections.singletonMap("error", "Incorrect number of games: " + noOfGames + ". The correct number of games is between 4-50.");
        } else {
            return quickPickService.getGames(noOfGames);
        }
    }

}
