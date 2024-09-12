package Youtube.TITV.OOP_Practice.Java61;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    protected String id;
    protected String fullName;
    protected int yearOfBirth;
    protected double averageScore;
    protected String userName;
    protected String password;

    public Student(){}
    public Student(String id, String fullName, int yearOfBirth, double averageScore) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.averageScore = averageScore;
        this.userName = "student" + id;
        this.password = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return " id:" + this.id + " || fullName:" + this.fullName + " || yearOfBirth:" + this.yearOfBirth + " || averageScore:" + this.averageScore + " || userName:" + this.userName + " || password:" + this.password;
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
