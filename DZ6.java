/**
  * Geekbrains. Java. Level 1. Lesson 6. Homework
  *
  * @author Andrey Klopov
  * @version dated 27 may 2017
  *1. Создать классы Собака и Кот с наследованием от класса Животное.
  *2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие. В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания), или высоту (для прыжков).
  *3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание: кот не умеет плавать, собака 10 м.).
  *4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль. (Например, dog1.run(150); -> результат: run: true)
  *5. * Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
*/
public class DZ6 {
public static void main(String[] args) {
    Animal[] animal = {new Cat(200, 2, 0), new Dog(500, 0.5f, 10)};
    for (Animal an : animal)
        System.out.println(
            an.getClass().getName() +
            "\nrun: " + an.run(200) +
            "\njump: " + an.jump(1.5f) +
            "\nswim: " + an.swim(5));
    }
}
class Cat extends Animal {
    Cat(int run_limit, float jump_limit, int swim_limit) {
        super(run_limit, jump_limit, swim_limit);
    }
    @Override
    protected boolean swim(int distance) {
        return false;
    }
}
class Dog extends Animal {
    Dog(int run_limit, float jump_limit, int swim_limit) {
        super(run_limit, jump_limit, swim_limit);
    }
}
abstract class Animal {
    private int run_limit;
    private float jump_limit;
    private int swim_limit;
    Animal(int run_limit, float jump_limit, int swim_limit) {
        this.run_limit = run_limit;
        this.jump_limit = jump_limit;
        this.swim_limit = swim_limit;
    }
    protected boolean run(int distance) {
        return distance <= run_limit;
    }
    protected boolean jump(float height)  {
        return height <= jump_limit;
    }
    protected boolean swim(int distance) {
        return distance <= swim_limit;
    }
}