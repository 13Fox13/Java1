/**
  * Geekbrains. Java. Level 1. Lesson 5. Homework
  *
  * @author Andrey Klopov
  * @version dated 24 may 2017
  *
  * Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст;
  * Конструктор класса должен заполнять эти поля при создании объекта;
  * Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль;
  * Создать массив из 5 сотрудников
  * С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
*/
public class DZ5 {
	public static void main(String[] args) {
		Employee[] empCorp = new Employee[5];
			empCorp[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",50000,41);
			empCorp[1] = new Employee("Petrov Petr", "Creator", "petrov@mailbox.com", "892312314",50000,32);
			empCorp[2] = new Employee("Sidorov Sidr", "Water pot", "sidorov@mailbox.com", "892312315",10000,43);
			empCorp[3] = new Employee("Pupkina Nadegda", "EnvelopeLicker", "pupkina@mailbox.com", "892312316",5000,18);
			empCorp[4] = new Employee("Juk J", "GrinderPencil", "juk@mailbox.com", "892312317",3000,21);
        for (Employee employee : empCorp)
        	if (employee.getAge()>40)
    		System.out.println(employee);

    }
}
class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

	public Employee(String name, String position, String email, String phone, int salary, int age) {
	this.name = name;
    this.position = position;
    this.email = email;
    this.phone = phone;
    this.salary = salary;
    this.age = age;
	} 
    public int getAge() {
		return age;
	}
	@Override
	public String toString(){
		return(name+ "\n-"
			+position+ "\n-"
			+email+ "\n-"
			+phone+ "\n-"
			+salary+ "\n-"
			+age);
	}
}