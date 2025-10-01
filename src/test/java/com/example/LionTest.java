package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class LionTest {

    @Test
    public void testMaleLionHasMane() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testFemaleLionHasNoMane() throws Exception {
        Lion lion = new Lion("Самка", new Feline());
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void testLionWithInvalidSexThrowsException() throws Exception {
        new Lion("Неопределенный", new Feline());
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самка", new Feline());
        List<String> food = lion.getFood();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFoodWithMock() throws Exception {
        // создаём мок
        Feline felineMock = Mockito.mock(Feline.class);

        // задаём поведение мока
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        // передаём мок в Lion
        Lion lion = new Lion("Самец", felineMock);

        // проверяем результат
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}