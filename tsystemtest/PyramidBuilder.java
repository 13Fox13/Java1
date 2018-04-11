package tsystemtest;

import java.util.*;

public class PyramidBuilder {

    public int[][] buildPyramid(List<Integer> inputNumbers) {
        // пирамида соберется, если отсортированные данные пригодны и прошли проверку
        if (!checkData(inputNumbers)) throw new CannotBuildPyramidException();
        int rows = determineRows(inputNumbers.size());
        int columns = determineColumns(inputNumbers.size());
        int [][] pyramid = determineMap(rows, columns);
        fillMap(pyramid, inputNumbers);
        return pyramid;
    }

    private boolean checkData(List<Integer> inputNumbers){
        //проверяем данные на пригодность
        if (inputNumbers==null || inputNumbers.size()==0 || inputNumbers.contains(null)) return false;
        long size = (long)inputNumbers.size();
        double res = (-1 + Math.sqrt(1+8*size))/2;
        if (res % 1 != 0) return false;
        return true;
    }

    private int determineRows(int listSize){
        // ищем количество строк
        return (int)(-1 + Math.sqrt(1+8*listSize))/2;
    }

    private int determineColumns(int listSize){
        // ищем количество столбцов
        return determineRows(listSize)*2-1;
    }

    private int[][] determineMap(int rowsNum, int columnsNum){
        // проверяем возможность постройки
        if (rowsNum <=0 || columnsNum <= 0) return null;
        int[][] map = new int[rowsNum][columnsNum]; // задаем размер
        for(int i = 0; i < rowsNum; i++){
            map[i] = new int[columnsNum];
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = 0;
            }
        }
        return map;
    }

    private static void fillMap(int[][] map, List<Integer> inputNumbers){
        if (map == null || inputNumbers == null || inputNumbers.size()==0) return;
        // сортируем
        inputNumbers.sort(Comparator.naturalOrder());
        int rows = map.length;
        int columns = rows*2-1;
        Iterator<Integer> iterator = inputNumbers.iterator();
        int middle = columns/2; // находим середину
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < i+1; j++){
                map[i][middle-i+j*2] = iterator.next();
            }
        }
    }

}