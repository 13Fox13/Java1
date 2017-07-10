/**
  * GeekBrains. Java. Level 1. Lesson 1. Homework
  *
  * @author Andrey Klopov
  * @version dated 10 may 2017
  *1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
  *2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
  *3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры этого метода;
  *4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
  *5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
  *6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
  *7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
  *8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
*/
public class DZ1 { 
	public static void main(String[] args) { 
		int a = 7; 
		int c = 32; 
		int d = 64; 
		byte b = 127; 
		short st = 12419; 
		char ch = 'A'; 
		int integer = 24; 
		long lg = 124124L; 
		float fl = 12.345949f; 
		double dl = 4323.45345; 
		boolean bool = true; 
		System.out.println(calc(a,b,c,d)); 
	} 
	static double calc(double a, double b, double c, double d) { 
		if(d == 0) return 0; return a * (b + (c / d)); 
	} 
	static boolean range(int one, int two) { 
		int sum = one + two; 
		return sum > 9 && sum < 21; 
	} 
	static void printPositiveOrNegative(int num) { 
		String word = "Положительное"; 
		if (num < 0) word = "Отрицательное"; 
		System.out.println(word); 
	} 
	static boolean isNegative(int num) { 
		return num < 0; 
	} 
	static void sayHello(String name) { 
		System.out.printf("Привет, %s!\n", name); 
	} static void printYear(int year) { 
		if (isLeapYear(year)) { System.out.println("Високосный"); 
	} else { 
		System.out.println("Не високосный"); 
		} 
	} 
	private static boolean isLeapYear(int year) { 
		if (((year % 4) == 0) && !((year % 100) == 0)) { 
			return true; 
		} else if ((year % 400) == 0) { 
			return true; 
		} return false; 
	} 
}