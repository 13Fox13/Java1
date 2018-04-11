package tsystemTest;

import java.util.List;

public class SubsequenceImpl implements Subsequence {

    public SubsequenceImpl() {}

    public boolean find(List<String> x, List<String> y) {
        boolean fl = true;
        int sizeX = x.size();
        int sizeY = y.size();
        int initial = 0; // начальное значение с которым будем сверяться, если найден эллемент в списке
        for (int i = 0; i < sizeX; i++) {
            for (int j = initial; j < sizeY; j++) {
                if (x.get(i).equals(y.get(j))) { // если эллементы из списков совпадают добавляем значение
                    initial = j;
                    break;
                }
                if ((j == (sizeY - 1)) && (initial != j)) fl = false;
            }

            if (!fl) break;
        }
        return fl;
    }
}
