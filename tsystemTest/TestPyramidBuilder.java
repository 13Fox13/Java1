package tsystemTest;

import java.util.*;

import org.junit.Test;
import org.junit.Assert;

    // Task 2. Pyramid Builder

public class TestPyramidBuilder {

    // Пришлось написать отдельный класс для тестрирования различных пирамид

    private PyramidBuilder pyramidBuilder = new PyramidBuilder();

    @Test
    public void buildPyramid0() {
        // получаем массив на проверку
        List<Integer> input = Arrays.asList(1, 3, 2);
        int[][] expected = new int[][]{
                {0, 1, 0},
                {2, 0, 3}};

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид
        checkPyramids(expected, pyramid);
    }

    @Test
    public void buildPyramid() {
        // получаем массив на проверку
        List<Integer> input = Arrays.asList(2, 4, 3, 5, 6, 1);
        int[][] expected = new int[][]{
                {0, 0, 1, 0, 0},
                {0, 2, 0, 3, 0},
                {4, 0, 5, 0, 6}};

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид
        checkPyramids(expected, pyramid);
    }

    @Test
    public void buildPyramid3() {
        // получаем массив на проверку
        List<Integer> input = Arrays.asList(10, 1, 3, 8, 7, 2, 9, 4, 5, 6);
        int[][] expected = new int[][]{
                {0, 0, 0, 1, 0, 0, 0},
                {0, 0, 2, 0, 3, 0, 0},
                {0, 4, 0, 5, 0, 6, 0},
                {7, 0, 8, 0, 9, 0, 10}};

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид
        checkPyramids(expected, pyramid);
    }

    @Test
    public void buildPyramid4() {
        // получаем массив на проверку
        List<Integer> input = Arrays.asList(5, 14, 10, 8, 11, 1, 12, 3, 2, 13, 9, 4, 7, 15, 6);
        int[][] expected = new int[][]{
                {0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 3, 0, 0, 0},
                {0, 0, 4, 0, 5, 0, 6, 0, 0},
                {0, 7, 0, 8, 0, 9, 0, 10, 0},
                {11, 0, 12, 0, 13, 0, 14, 0, 15}
        };

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид
        checkPyramids(expected, pyramid);
    }

    @Test
    public void buildPyramid5() {
        // получаем массив на проверку
        List<Integer> input = Arrays.asList(17, 5, 14, 10, 18, 8, 7, 19, 11, 1, 21, 12, 3, 16, 2, 13, 9, 4, 15, 6, 20);
        int[][] expected = new int[][]{
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 4, 0, 5, 0, 6, 0, 0, 0},
                {0, 0, 7, 0, 8, 0, 9, 0, 10, 0, 0},
                {0, 11, 0, 12, 0, 13, 0, 14, 0, 15, 0},
                {16, 0, 17, 0, 18, 0, 19, 0, 20, 0, 21}
        };

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид
        checkPyramids(expected, pyramid);
    }


    @Test(expected = CannotBuildPyramidException.class)
    public void buildPyramid1() {
        // получаем массив на проверку
        List<Integer> input = Arrays.asList(1, 3, 2, 9, 4, null);

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид (попали в исключения)
    }

    @Test(expected = CannotBuildPyramidException.class)
    public void buildPyramid2() {
        // получаем массив на проверку
        List<Integer> input = Arrays.asList(9, 4, 1, 3, 2, 5, null);

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид (попали в исключения)
    }

    @Test(expected = CannotBuildPyramidException.class)
    public void buildPyramid6() {
        // получаем массив на проверку
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i < 300; i++) {
            input.add(i);
        }

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид (попали в исключения)
    }

    @Test(expected = CannotBuildPyramidException.class)
    public void buildPyramid7() {
        // получаем массив на проверку
        List<Integer> input = new ArrayList<>();
        for (int i = 1; i < 2000; i++) {
            input.add(i);
        }

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид (попали в исключения)
    }

    @Test(expected = CannotBuildPyramidException.class)
    public void buildPyramid8() {
        // получаем массив на проверку
        List<Integer> input = Collections.nCopies(Integer.MAX_VALUE - 1, 0);

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид (попали в исключения)
    }

    @Test
    public void buildPyramid9() {
        // получаем массив на проверку (проверим массив с 0)
        List<Integer> input = Arrays.asList(1, 3, 2, 0, 4, 5);
        int[][] expected = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 0, 2, 0},
                {3, 0, 4, 0, 5}};

        // запускаем
        int[][] pyramid = pyramidBuilder.buildPyramid(input);

        // результат сравнения пирамид
        checkPyramids(expected, pyramid);
    }

    private void checkPyramids(int[][] expected, int[][] pyramid) {
        Assert.assertEquals("Amount of rows is different.", expected.length, pyramid.length);
        for (int i = 0; i < expected.length; i++) {
            Assert.assertArrayEquals(expected[i], pyramid[i]);
        }
    }
}