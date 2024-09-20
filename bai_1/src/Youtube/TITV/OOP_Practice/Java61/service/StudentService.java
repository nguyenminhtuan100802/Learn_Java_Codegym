package Youtube.TITV.OOP_Practice.Java61.service;

import Youtube.TITV.OOP_Practice.Java61.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    ArrayList<Student> studentArrayList;
    public StudentService() {
        this.studentArrayList = new ArrayList<Student>();
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }

    public void login(){
        System.out.print("Enter your username:");
        String userNameStudent = new Scanner(System.in).nextLine();
        System.out.print("Enter your password:");
        String passwordStudent = new Scanner(System.in).nextLine();

        Student student = new Student();
        student = this.verifyStudentAccount(userNameStudent, passwordStudent);
        if (student != null) {
            System.out.println("Student login successfully");
        }
        else {
            System.out.println("Username or password is incorrect");
        }
    }

    public int getListSize() {
        return this.studentArrayList.size();
    }
    public void addNewStudent() {
//        this.saveStudentsToDatabase(student);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student ID: "); String id = input.nextLine();
        System.out.print("Enter student Full Name: "); String fullName = input.nextLine();
        System.out.print("Enter student Year of Birth: "); int yearOfBirth = input.nextInt();
        System.out.print("Enter student average score: "); double averageScore = input.nextDouble();

        this.studentArrayList.add(new Student(id, fullName, yearOfBirth, averageScore));
        this.saveStudentToFile();
    }
    public void checkListEmpty() {
        if (this.studentArrayList.isEmpty()){
            System.out.println("There are 0 student in your list");
        }
        else {
            System.out.println("There are " + this.studentArrayList.size() + " students in your list");
        }
    }
    public void printStudents() {
        this.loadStudentsFromFile();
        //        this.loadStudentsFromDatabase();
        System.out.println("------------------ Student List ------------------");
        System.out.printf("%-5s %-20s %-15s %-10s %-15s %-15s%n",
                "ID", "Name", "Year of birth", "Score", "Username", "Password");
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            System.out.printf("%-5s %-20s %-15s %-10s %-15s %-15s%n",
                    this.studentArrayList.get(i).getId(),
                    this.studentArrayList.get(i).getFullName(),
                    this.studentArrayList.get(i).getYearOfBirth(),
                    this.studentArrayList.get(i).getAverageScore(),
                    this.studentArrayList.get(i).getAccount().getUserName(),
                    this.studentArrayList.get(i).getAccount().getPassword());
        }
    }
    public void clearAllStudents(){
        this.studentArrayList.clear();
        this.saveStudentToFile();
        System.out.println("Clear all student list successfully");
    }

    public Student verifyStudentAccount(String username, String password) {
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (studentArrayList.get(i).getAccount().getUserName().equals(username) &&
                    studentArrayList.get(i).getAccount().getPassword().equals(password)) {
                return this.studentArrayList.get(i);
            }
        }
        return null;
    }
    public void findStudentsByID() {
        System.out.print("Enter student ID:");
        String inputID = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getId().equals(inputID)) {
                isFound = true;
                System.out.println("Student " + (i + 1) + this.studentArrayList.get(i).toString());
            }
        }
        if (!isFound) {
            System.out.println("Student " + inputID + " not found");
        }
    }
    public void editStudentId() {
        boolean found = false;
        System.out.print("Enter student ID you want to find:");
        String inputID = new Scanner(System.in).nextLine();
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getId().equals(inputID)) {
                System.out.println("Found student:" + this.studentArrayList.get(i).toString());
                System.out.print("Enter ID you want to edit:");
                String editID = new Scanner(System.in).nextLine();
                this.studentArrayList.get(i).setId(editID);
                this.saveStudentToFile();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student " + inputID + " not found");
        }
    }

    public void findStudentsByName() {
        System.out.print("Enter student name:");
        String inputName = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getFullName().equals(inputName)) {
                isFound = true;
                System.out.println("Student " + (i + 1) + this.studentArrayList.get(i).toString());
            }
        }
        if (!isFound) {
            System.out.println("Student " + inputName + " not found");
        }
    }

    public void findStudentsByYearOfBirth() {
        System.out.print("Enter student year of birth:");
        int inputYearOfBirth = new Scanner(System.in).nextInt();
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getYearOfBirth() == inputYearOfBirth) {
                isFound = true;
                System.out.println("Student " + (i + 1) + this.studentArrayList.get(i).toString());
            }
        }
        if (!isFound) {
            System.out.println("Student " + inputYearOfBirth + " not found");
        }
    }
    public void removeStudentByID() {
        System.out.print("Enter student ID:");
        String inputID = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getId().equals(inputID)) {
                isFound = true;
                this.studentArrayList.remove(i);
                System.out.println("Remove successfully");
                break;
            }
        }
        if (!isFound) {
            System.out.println("Student " + inputID + " not found");
        }
    }
    public void removeStudentByName() {
        System.out.print("Enter student name:");
        String inputName = new Scanner(System.in).nextLine();
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getFullName().equals(inputName)) {
                isFound = true;
                this.studentArrayList.remove(i);
                System.out.println("Remove successfully");
                break;
            }
        }
        if (!isFound) {
            System.out.println("Student " + inputName + " not found");
        }
    }
    public void removeStudentByYearOfBirth() {
        System.out.print("Enter student year of birth:");
        int inputYearOfBirth = new Scanner(System.in).nextInt();
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getYearOfBirth() == inputYearOfBirth) {
                isFound = true;
                this.studentArrayList.remove(i);
                System.out.println("Remove successfully");
                break;
            }
        }
        if (!isFound) {
            System.out.println("Student " + inputYearOfBirth + " not found");
        }
    }
    public void sortByScore(String sortType){
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            for (int j = i + 1; j < this.studentArrayList.size(); j++) {
                if (sortType.equals("ascend")){
                    if (studentArrayList.get(i).getAverageScore() > studentArrayList.get(j).getAverageScore()) {
                        Student temp = studentArrayList.get(i);
                        studentArrayList.set(i, studentArrayList.get(j));
                        studentArrayList.set(j, temp);
                    }
                }
                else if (sortType.equals("descend")){
                    if (studentArrayList.get(i).getAverageScore() < studentArrayList.get(j).getAverageScore()) {
                        Student temp = studentArrayList.get(i);
                        studentArrayList.set(i, studentArrayList.get(j));
                        studentArrayList.set(j, temp);
                    }
                }
            }
        }
    }
    public void saveStudentToFile(){
        FileService.saveStudentsToFile(studentArrayList);
    }
    public void loadStudentsFromFile(){
        studentArrayList = FileService.loadStudentsFromFile();
    }
//    public void loadStudentsFromDatabase(){
//        studentArrayList = StudentDAO.getInstance().getAll();
//    }
//    public void saveStudentsToDatabase(Student student){
//        StudentDAO.getInstance().insert(student);
//    }
}
