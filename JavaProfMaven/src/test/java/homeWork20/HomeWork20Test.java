package homeWork20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HomeWork20Test {
    private HomeWork20 arrFunc;
    private int[][] arrays = {{1, 2, 4, 3, 4, 6}, {4, 5, 5, 5}, {7, 6, 4, 9, 4}};
    private int[][] arraysStar = {{1, 4, 4, 3, 4, 1}, {4, 4, 4, 4}, {1, 1, 1, 1, 1}, {4, 1, 4, 4}};

    @BeforeEach
    public void init() {
        arrFunc = new HomeWork20();
    }

    @CsvSource({
            "2, 2, 4",
            "-2, -2, -4"
    })

    @ParameterizedTest
    public void massTest

    @Test
    public void testFiltArray() {
        Assertions.assertEquals(Arrays.toString(new int[]{6}), Arrays.toString(arrFunc.oneDimArr(arrays[0])));
        Assertions.assertEquals(Arrays.toString(new int[]{5, 5, 5}), Arrays.toString(arrFunc.oneDimArr(arrays[1])));
        Assertions.assertEquals(Arrays.toString(new int[]{}), Arrays.toString(arrFunc.oneDimArr(arrays[2])));
    }

    @Test
    public void testScanArray() {
        Assertions.assertEquals(false, arrFunc.scanArray(arraysStar[0]));
        Assertions.assertEquals(false, arrFunc.scanArray(arraysStar[1]));
        Assertions.assertEquals(false, arrFunc.scanArray(arraysStar[2]));
        Assertions.assertEquals(true, arrFunc.scanArray(arraysStar[3]));
    }
}
