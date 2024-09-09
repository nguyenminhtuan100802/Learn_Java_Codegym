package Youtube.TITV.OOP.OOP_Inheritance;

public class People {
    private String fullName;
    private int yearOfBirth;
    public People(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void eat(){
        System.out.println("Eating...");
    }
    public void sleep(){
        System.out.println("Sleeping...");
    }
    public void drink(){
        System.out.println("Drinking...");
    }
}
