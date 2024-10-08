package Document.Codegym.AccessModifier.Student;

public class Student {
    private String name;
    private int age;
    public static String school = "code gym hcm";
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name: " + name  +
                " || age: " + age +
                " || school: " + school +
                '}';
    }
}
