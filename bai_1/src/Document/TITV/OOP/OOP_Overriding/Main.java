package Document.TITV.OOP.OOP_Overriding;

public class Main {
    public static void main(String[] args) {
//         overriding: rewrite method in child class from parent class which has same method name, same parameter
        Animal animal = new Animal("milu");
        animal.eat();
        animal.makeSound();

        Cat cat = new Cat("lu");
        cat.eat();
        cat.makeSound();
    }
}
