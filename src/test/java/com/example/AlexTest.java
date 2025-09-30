package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AlexTest {

    private Alex alex;

    @Before
    public void setUp() throws Exception {
        alex = new Alex(new Feline());
    }

    @Test
    public void testGetFriends() {
        List<String> expectedFriends = List.of("Марти", "Глория", "Мелман");
        assertEquals(expectedFriends, alex.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void testGetKittens() {
        assertEquals(0, alex.getKittens());
    }
}