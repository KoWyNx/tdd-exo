package org.example.exercice3;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DiceScoreTest {

    private Ide mockIde;
    private DiceScore diceScore;

    @Before
    public void setUp() {
        mockIde = Mockito.mock(Ide.class);
        diceScore = new DiceScore();
        diceScore.de = mockIde;
    }

    @Test
    public void testGetScore_ReturnsDoublePlus10_WhenDiceAreEqualAndLessThan6() {
        when(mockIde.getRoll()).thenReturn(4);

        int score = diceScore.getScore();

        assertEquals(18, score);
    }

    @Test
    public void testGetScore_Returns30_WhenBothDiceAreSixes() {
        when(mockIde.getRoll()).thenReturn(6);

        int score = diceScore.getScore();

        assertEquals(30, score);
    }

    @Test
    public void testGetScore_ReturnsHigherValue_WhenDiceAreDifferent() {
        when(mockIde.getRoll()).thenReturn(3).thenReturn(5);

        int score = diceScore.getScore();

        assertEquals(5, score);
    }
}
