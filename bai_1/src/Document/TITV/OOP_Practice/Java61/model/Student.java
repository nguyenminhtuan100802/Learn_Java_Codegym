package Document.TITV.OOP_Practice.Java61.model;

import java.io.Serializable;

public class Student implements Serializable {
    protected String id;
    protected String fullName;
    protected int yearOfBirth;
    protected double averageScore;
    protected Account account;

    public Student(){}
    public Student(String id, String fullName, int yearOfBirth, double averageScore) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.averageScore = averageScore;
        this.account = new Account();
        this.account.setUserName("student" + this.id);
        this.account.setPassword("student" + this.id);
    }
    public Student(String id, String fullName, int yearOfBirth, double averageScore, String username, String password) {
        this.id = id;
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.averageScore = averageScore;
        this.account = new Account();
        this.account.setUserName(username);
        this.account.setPassword(password);
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return " id:" + this.id +
                " || fullName:" + this.fullName +
                " || yearOfBirth:" + this.yearOfBirth +
                " || averageScore:" + this.averageScore +
                " || userName:" + this.account.getUserName() +
                " || password:" + this.account.getPassword();
    }

//    public static Student createNewStudent() {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter student ID: ");
//        String id = input.nextLine();
//        System.out.print("Enter student Full Name: ");
//        String fullName = input.nextLine();
//        System.out.print("Enter student Year of Birth: ");
//        int yearOfBirth = input.nextInt();
//        System.out.print("Enter student average score: ");
//        double averageScore = input.nextDouble();
//
//        return new Student(id, fullName, yearOfBirth, averageScore);
//    }
//    public void login(StudentList studentList){
//        System.out.print("Enter your username:");
//        String userNameStudent = new Scanner(System.in).nextLine();
//        System.out.print("Enter your password:");
//        String passwordStudent = new Scanner(System.in).nextLine();
//
//        Student student = new Student();
//        student = studentList.verifyStudentAccount(userNameStudent, passwordStudent);
//        if (student != null) {
//            System.out.println("Student login successfully");
//        }
//        else {
//            System.out.println("Username or password is incorrect");
//        }
//    }
}
