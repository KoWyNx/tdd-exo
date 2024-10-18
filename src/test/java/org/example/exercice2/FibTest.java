package org.example.exercice2;

import static org.junit.Assert.*;

import TDD.exercice2.Fib;
import org.junit.Test;
import java.util.List;

public class FibTest {

    @Test
    public void testGetFibSeriesWithRangeOne_IsNotEmpty() {
        Fib fib = new Fib(1);
        List<Integer> result = fib.getFibSeries();

        assertFalse("La liste ne doit pas être vide", result.isEmpty());
    }

    @Test
    public void testGetFibSeriesWithRangeOne_ReturnsZero() {
        Fib fib = new Fib(1);
        List<Integer> result = fib.getFibSeries();

        assertEquals("La liste doit contenir uniquement 0", List.of(0), result);
    }

    @Test
    public void testGetFibSeriesWithRangeSix_ContainsThree() {
        Fib fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();

        assertTrue("La liste doit contenir le chiffre 3", result.contains(3));
    }

    @Test
    public void testGetFibSeriesWithRangeSix_HasSixElements() {
        Fib fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();

        assertEquals("La taille de la liste doit être 6", 6, result.size());
    }

    @Test
    public void testGetFibSeriesWithRangeSix_DoesNotContainFour() {
        Fib fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();

        assertFalse("La liste ne doit pas contenir le chiffre 4", result.contains(4));
    }

    @Test
    public void testGetFibSeriesWithRangeSix_MatchesExpectedSeriesAndIsSorted() {
        Fib fib = new Fib(6);
        List<Integer> result = fib.getFibSeries();

        List<Integer> expected = List.of(0, 1, 1, 2, 3, 5);
        assertEquals("La liste doit être égale à {0, 1, 1, 2, 3, 5}", expected, result);

        for (int i = 0; i < result.size() - 1; i++) {
            assertTrue("La liste doit être triée de manière ascendante", result.get(i) <= result.get(i + 1));
        }
    }
}
