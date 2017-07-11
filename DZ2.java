/**
  * GeekBrains. Java. Level 1. Lesson 2. Homework
  *
  * @author Andrey Klopov
  * @version dated 13 may 2017
  *1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
  *2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
  *3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
  *4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
  *5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
  *6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят.
  *7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
*/
class DZ2 {
	public static void main(String[] args) {
		int[] arr = { 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 0 };
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] == 1) {
                	arr[i] = 0;
            	}else arr[i] = 1;
            }	
        	for(int i = 0; i < arr.length; i++){
            	System.out.print (" " + arr[i]+" ");
			}
	System.out.println("");
		int[] nums = {0, 3, 6, 9, 12, 15, 18, 21};
				System.out.println("nums.length: " + nums.length); 
				for (int i = 0; i < nums.length; i++) {
					System.out.print(nums[i] + " "); 
				}
	System.out.println("");
		int[] two = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
			for(int i = 0; i < two.length; i++) {
        		if(two[i] <6) two[i] = two[i] * 2;
            }
        	for(int i = 0; i < two.length; i++){
            System.out.print (i + "-" + two[i]+" ");
        	}
    System.out.println("");
    	int[][] kvadrat = new int[4][4]; 
    		for (int i = 0; i < 4; i++) {
    			System.out.println("");
				for (int j = 0; j < 4; j++) { 
					kvadrat[i][j] = i+j;
			System.out.print(kvadrat[i][j] + " ");
				}
			}	
	System.out.println("");
		int[] mas = {1, 5, 10, 15, 20};
        int min = mas[0], max = mas[0], i, imin = 0, imax = 0;
        for(i = 0; i != mas.length; i++)
        {
            if(mas[i] < min){
                min = mas[i];
                imin = i;
            }
            if(mas[i] > max){
                max = mas[i];
                imax = i;
            }
            System.out.println("max = "+max+" min = "+min);
            System.out.println("imax = "+imax+" imin = "+imin);
        }
	System.out.println("");
    }
    static boolean checkBalance(int[] array) {
    	int length;
		int first;
		int second;
		for (int i = 0; i < array.length - 1; i++) {
            first = 0;
            second = 0;
		for (int j = 0; j <= i; j++) {
                first += array[j];
            }
		for (int x = i + 1; x < array.length; x++) {
                second += array[x];
            }
		if (first == second) return true;
        }
	return false;
    }
}		