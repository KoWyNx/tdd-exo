package org.example.exercice1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GradingCalculatorTest {

    @Test
    public void testGetGrade_ReturnsA_WhenScoreIs95AndAttendanceIs90() {
        GradingCalculator calculator = new GradingCalculator(95, 90);
        char grade = calculator.getGrade();
        assertEquals('A', grade);
    }

    @Test
    public void testGetGrade_ReturnsB_WhenScoreIs85AndAttendanceIs90() {
        GradingCalculator calculator = new GradingCalculator(85, 90);
        char grade = calculator.getGrade();
        assertEquals('B', grade);
    }

    @Test
    public void testGetGrade_ReturnsC_WhenScoreIs65AndAttendanceIs90() {
        GradingCalculator calculator = new GradingCalculator(65, 90);
        char grade = calculator.getGrade();
        assertEquals('C', grade);
    }

    @Test
    public void testGetGrade_ReturnsB_WhenScoreIs95AndAttendanceIs65() {
        GradingCalculator calculator = new GradingCalculator(95, 65);
        char grade = calculator.getGrade();
        assertEquals('B', grade);
    }

    @Test
    public void testGetGrade_ReturnsF_WhenScoreIs95AndAttendanceIs55() {
        GradingCalculator calculator = new GradingCalculator(95, 55);
        char grade = calculator.getGrade();
        assertEquals('F', grade);
    }

    @Test
    public void testGetGrade_ReturnsF_WhenScoreIs65AndAttendanceIs55() {
        GradingCalculator calculator = new GradingCalculator(65, 55);
        char grade = calculator.getGrade();
        assertEquals('F', grade);
    }

    @Test
    public void testGetGrade_ReturnsF_WhenScoreIs50AndAttendanceIs90() {
        GradingCalculator calculator = new GradingCalculator(50, 90);
        char grade = calculator.getGrade();
        assertEquals('F', grade);
    }
}
