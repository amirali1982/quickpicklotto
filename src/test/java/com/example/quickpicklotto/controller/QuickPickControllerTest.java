package com.example.quickpicklotto.controller;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuickPickControllerTest {

    QuickPickController quickPickController = new QuickPickController();

    @Test
    void getQuickPick() {
        Map<String, String> quickPickResponse = quickPickController.getQuickPick();
        assertEquals(QuickPickController.WELCOME_MESSAGE, quickPickResponse.get("response"));
    }

    @Test
    void testGetQuickPick_GameGeneration_OutOfRange() {
        Map<String, String> quickPickResponse = (Map<String, String>) quickPickController.getQuickPick(3L);
        assertEquals("Incorrect number of games: 3. The correct number of games is between 4-50.", quickPickResponse.get("error"));

        quickPickResponse = (Map<String, String>) quickPickController.getQuickPick(55L);
        assertEquals("Incorrect number of games: 55. The correct number of games is between 4-50.", quickPickResponse.get("error"));
    }

    @Test
    void testGetQuickPick_GameGeneration_Positive() {
        Set<Set<Integer>> quickPickResponse = (Set<Set<Integer>>) quickPickController.getQuickPick(4L);
        assertEquals(4, quickPickResponse.size());

        quickPickResponse = (Set<Set<Integer>>) quickPickController.getQuickPick(50L);
        assertEquals(50, quickPickResponse.size());
    }
}