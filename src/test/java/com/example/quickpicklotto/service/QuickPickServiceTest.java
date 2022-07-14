package com.example.quickpicklotto.service;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickPickServiceTest {

    QuickPickService quickPickService = new QuickPickService();

    @Test
    void getGame_ShouldNotHaveDuplicateNumberInARetrievedGame() {
        Set<Integer> game = quickPickService.getGame();
        List<Integer> numberList = new ArrayList<>(game);

        //Adding some existing numbers in the game
        game.add(numberList.get(0));
        game.add(numberList.get(3));
        game.add(numberList.get(5));

        //making sure our returned game collection should not add a duplicate number
        assertEquals(QuickPickService.NUMBERS_PER_GAME, game.size());
    }

    @Test
    void getGames_ShouldNotHaveDuplicate() {

        Set<Set<Integer>> games = quickPickService.getGames(4L);
        List<Set<Integer>> gameList = new ArrayList<>(games);

        //Add a copy of existing game into the collection
        games.add(ObjectUtils.clone(gameList.get(0)));
        games.add(ObjectUtils.clone(gameList.get(1)));

        //Making sure our game collection doesn't contain any duplicate game due to future implementation changes.
        assertEquals(4, games.size());
    }
}