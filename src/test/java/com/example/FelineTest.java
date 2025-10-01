package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private final Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @RunWith(Parameterized.class)
    public static class GetKittensParameterizedTest {
        private final int kittensCount;

        public GetKittensParameterizedTest(int kittensCount) {
            this.kittensCount = kittensCount;
        }

        @Parameterized.Parameters(name = "Количество котят: {0}")
        public static Object[] data() {
            return new Object[]{0, 1, 5};
        }

        @Test
        public void testGetKittensWithParameter() {
            Feline feline = new Feline();
            assertEquals(kittensCount, feline.getKittens(kittensCount));
        }
    }
}