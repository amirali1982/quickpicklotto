package com.example.quickpicklotto.service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class QuickPickService {

    public static final int NUMBERS_PER_GAME = 7;
    public static final int MAX_NUMBER_VALUE = 47;

    public Set<Set<Integer>> getGames(Long numberOfGames) {
        Set<Set<Integer>> games = new HashSet<>();
        while (games.size() < numberOfGames) {
            games.add(this.getGame());
        }
        return games;
    }

    Set<Integer> getGame() {
        Set<Integer> game = new TreeSet<>();
        while (game.size() < NUMBERS_PER_GAME) {
            game.add(new Random().nextInt(MAX_NUMBER_VALUE) + 1);
        }
        return game;
    }
}
