package Youtube.TITV.OOP_Practice.Java61;

import java.util.Scanner;

public class Student {
    protected String id;
    protected String fullName;
    protected int yearOfBirth;
    protected double averageScore;

    public Student(){}
    public Student(String id, String fullName, int yearOfBirth, double averageScore) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.averageScore = averageScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return " id:" + this.id + "--fullName:" + this.fullName + "--yearOfBirth:" + this.yearOfBirth + "--averageScore:" + this.averageScore;
    }

    public Student createNewStudent() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student ID: ");
        String id = input.nextLine();
        System.out.print("Enter student Full Name: ");
        String fullName = input.nextLine();
        System.out.print("Enter student Year of Birth: ");
        int yearOfBirth = input.nextInt();
        System.out.print("Enter student average score: ");
        double averageScore = input.nextDouble();

        return new Student(id, fullName, yearOfBirth, averageScore);
    }
}
