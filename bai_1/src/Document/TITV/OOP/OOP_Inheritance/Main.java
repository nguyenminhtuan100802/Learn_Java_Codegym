package Document.TITV.OOP.OOP_Inheritance;

public class Main {
    public static void main(String[] args) {
        People people = new People("tuan", 2020);
        System.out.println("people");
        people.eat();
        people.drink();
        people.sleep();
        Student student = new Student("tuan", 2002, "frontend", "codegym");
        System.out.println("student");
        student.eat();
        student.drink();
        student.sleep();
        student.doHomework();

    }
}
