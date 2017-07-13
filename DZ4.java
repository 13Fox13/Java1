/**
  * GeekBrains. Java. Level 1. Lesson 4. Homework
  *
  * @author Andrey Klopov
  * @version dated 19 may 2017
  *1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку;
  *2. Переделать проверку победы, чтобы она не была реализована просто набором условий, например, с использованием циклов.
  *3. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4. Очень желательно не делать это просто набором условий для каждой из возможных ситуаций;
  *4. *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
*/
import java.util.Random;
import java.util.Scanner;
class DZ4 {
	final int SIZE = 5;
	final char DOT_X = 'x';
	final char DOT_O = 'o';
	final char DOT_EMPTY = '.';
	char[][] map = new char [SIZE][SIZE];
	Scanner sc = new Scanner(System.in);
	Random rand = new Random();
	public static void main(String[] args) {
		new DZ4().go();
	}
	void go(){
		initMap();
		while (true){
			humanTurn();
			printMap();
			if(checkWin(DOT_X)){
				System.out.println("YOU WON!");
				break;
			}
			if (isMapFull()){
				System.out.println("Sorry, DRAW");
				break;
			}
			aiTurn();
			printMap();
			if(checkWin(DOT_O)){
				System.out.println("AI WON");
				break;
			}
		}
		System.out.println("GAME OVER.");
	}
	void printMap() {
        for(int y = 0; y < 5; ++y) {
            System.out.print((y + 1) + " ");
            for(int x = 0; x < 5; ++x) {
                System.out.print(map[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    void initMap() {
		map = new char[SIZE][SIZE];
			for (int i = 0; i < SIZE; i++) {
				for (int j = 0; j < SIZE; j++) { 
					map[i][j] = DOT_EMPTY;
				} 
			}
	}
    void humanTurn() {
        int x;
        int y;
        while (true) {
            System.out.print("Введи Х_Y: ");
            if (sc.hasNextInt()) {
                y = sc.nextInt() - 1;
            }
            else {
                System.out.println("Ты ошибся. Повтори:");
                continue;
            }
            if (sc.hasNextInt()) {
                x = sc.nextInt() - 1;
            }
            else {
                System.out.println("Ты ошибся. Повтори:");
                continue;
            }
            if (isCellValid(y, x) && isCellEmpty(y, x)) {
                map[y][x] = DOT_X;
                break;
            }
            System.out.println("Ты ошибся. Повтори:");
        }
    }
    void aiTurn() {
        int y;
        int x;
        while (true) {
            y = rand.nextInt(5);
            x = rand.nextInt(5);
            if (isCellEmpty(y,x)) {
                System.out.println("Ход компьютера X_Y: " + (y + 1) + " " + (x + 1));
                map[y][x] = DOT_O;
                break;
            }
        }
    }

    boolean isCellValid(int y, int x) {
        return y >= 0 && y <= 4 && x >= 0 && y <= 4;
    }
    boolean isCellEmpty(int y, int x) {
        return map[y][x] == DOT_EMPTY;
    }

    boolean isMapFull() {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if(map[y][x] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean checkWin(char symb) {
        int strafeX; 
        int y; 
        for (strafeX = 0; strafeX < 2; ++strafeX) {
            for (y = 0; y < 5; ++y) {
                if (map[y][0 + strafeX] == symb && map[y][1 + strafeX] == symb && map[y][2 + strafeX] == symb && map[y][3 + strafeX] == symb) {
                    return true;
                }
            }
        }
        for (strafeX = 0; strafeX < 2; ++strafeX) {
            for (y = 0; y < 5; ++y) {
                if (map[0 + strafeX][y] == symb && map[1 + strafeX][y] == symb && map[2 + strafeX][y] == symb && map[3 + strafeX][y] == symb) {
                    return true;
                }
            }
        }
        for (strafeX = 0; strafeX < 2; ++strafeX) {
            for (y = 0; y < 2; ++y) {
                if (map[0 + strafeX][0 + y] == symb && map[1 + strafeX][1 + y] == symb && map[2 + strafeX][2 + y] == symb && map[3 + strafeX][3 + y] == symb) {
                    return true;
                }

                if (map[4 - strafeX][0 + y] == symb && map[3 - strafeX][1 + y] == symb && map[2 - strafeX][2 + y] == symb && map[1 - strafeX][3 + y] == symb) {
                    return true;
                }
            }
        }
        return false;
    }
}