package Youtube.TITV.OOP.OOP_Overriding;

public class Animal {
    protected String name;
    public Animal(String name) {
        this.name = name;
    }
    public void eat(){
        System.out.println("Eating something");
    }
    public void makeSound(){
        System.out.println("Do not know");
    }
}
