package Document.TITV.OOP.OOP_Overriding;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Eating fish, mouse");
    }

    @Override
    public void makeSound() {
        System.out.println("Meo meo");
    }
}
