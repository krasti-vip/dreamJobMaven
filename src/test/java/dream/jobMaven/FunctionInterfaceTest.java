package dream.jobMaven;

import org.example.baseJava.steep19.functionalInterface.MetodFunctionalInterface;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionInterfaceTest {

    MetodFunctionalInterface mfi = new MetodFunctionalInterface();

    @Test
    public void testFilterArrayEvenNumbers() {
        int[] input = {1, 2, 3, 4, 5, 6};
        int[] expected = {2, 4, 6};

        int[] result = mfi.filterArray(input, number -> number % 2 == 0);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFilterArrayGreaterThanThree() {
        int[] input = {1, 2, 3, 4, 5, 6};
        int[] expected = {4, 5, 6};

        int[] result = mfi.filterArray(input, number -> number > 3);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFilterArrayNoConditionMet() {
        int[] input = {1, 2, 3};
        int[] expected = {};  // Ожидаем пустой массив

        int[] result = mfi.filterArray(input, number -> number > 5);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testTransformArray() {
        int[] input = {1, 2, 3};
        int[] expected = {3, 4, 5};

        int[] result = mfi.transformArray(input, n -> n + 2);
        assertArrayEquals(expected, result);

        int[] expected2 = {1, 4, 9};
        int[] result2 = mfi.transformArray(input, n -> n * n);
        assertArrayEquals(expected2, result2);
    }

    @Test
    public void testFindMaxEven() {
        int[] input = {1, 2, 3, 4, 5, 6};
        int expected = 6;

        int result = mfi.findMax(input, n -> n % 2 == 0);
        assertEquals(expected, result);

        int[] input2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int expected2 = 10;

        int result2 = mfi.findMax(input2, n -> n > 5);
        assertEquals(expected2, result2);
    }

    @Test
    public void testAggregateArraySum() {
        double[] input = {1.0, 2.5, 3.5, 4.0};
        double expected = 11.0;

        double result = mfi.aggregateArray(input, (a, b) -> a + b, 0.0);
        assertEquals(expected, result);
    }

    @Test
    public void testAggregateArrayProduct() {
        double[] input = {1.0, 2.0, 3.0, 4.0};
        double expected = 24.0;

        double result = mfi.aggregateArray(input, (a, b) -> a * b, 1.0);
        assertEquals(expected, result);
    }

    @Test
    public void testAllCheckEven() {
        int[] input = {2, 4, 6, 8, 10};
        assertTrue(mfi.allCheck(input, n -> n % 2 == 0));
    }

    @Test
    public void testAllCheckGreaterThanZero() {
        int[] input = {2, 4, 6, 8, 10};
        assertTrue(mfi.allCheck(input, n -> n > 0));
    }

    @Test
    public void testAllCheckLessThanFive() {
        int[] input = {2, 4, 6, 8, 10};
        assertFalse(mfi.allCheck(input, n -> n < 5));
    }
}
