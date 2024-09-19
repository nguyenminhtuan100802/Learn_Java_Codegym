package Youtube.TITV.OOP_Practice.Java61.user;

import Youtube.TITV.OOP_Practice.Java61.mini_database.StudentDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    ArrayList<Student> studentArrayList;
    public StudentList() {
        this.studentArrayList = new ArrayList<Student>();
    }

    public int getListSize() {
        return this.studentArrayList.size();
    }
    public void addNewStudent(Student student) {
//        this.saveStudentsToFile();
        this.saveStudentsToDatabase(student);
//        this.studentArrayList.add(student);
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
//        this.saveStudentsToFile();
        this.loadStudentsFromDatabase();
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
    public void setStudentId(String oldId, String newId) {
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getId().equals(oldId)) {
                this.studentArrayList.get(i).setId(newId);
                System.out.println("Student after edit id:" + this.studentArrayList.get(i).toString());
            }
        }
    }
    public String getStudentByID(String id) {
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getId().equals(id)) {
                return studentArrayList.get(i).toString();
            }
        }
        return null;
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
    public void removeStudentByID(String id) {
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getId().equals(id)) {
                isFound = true;
                this.studentArrayList.remove(i);
                System.out.println("Remove successfully");
                break;
            }
        }
        if (!isFound) {
            System.out.println("Student " + id + " not found");
        }
    }
    public void removeStudentByName(String name) {
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getFullName().equals(name)) {
                isFound = true;
                this.studentArrayList.remove(i);
                System.out.println("Remove successfully");
                break;
            }
        }
        if (!isFound) {
            System.out.println("Student " + name + " not found");
        }
    }
    public void removeStudentByYearOfBirth(int yearOfBirth) {
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getYearOfBirth() == yearOfBirth) {
                isFound = true;
                this.studentArrayList.remove(i);
                System.out.println("Remove successfully");
                break;
            }
        }
        if (!isFound) {
            System.out.println("Student " + yearOfBirth + " not found");
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
    public void loadStudentsFromDatabase(){
        studentArrayList = StudentDAO.getInstance().getAll();
    }
    public void saveStudentsToDatabase(Student student){
        StudentDAO.getInstance().insert(student);
    }


    public void saveStudentsToFile(){
        try {
            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\OOP_Practice\\Java61\\mini_database\\students.csv";
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("Hello mn\n");
            fileWriter.write("Lai la chao day\n");
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadStudentsFromFile() {
        try {
            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\OOP_Practice\\Java61\\mini_database\\students.csv";
            FileReader fileReader = new FileReader(fileName);
            int character = fileReader.read();
            while (character != -1) {
                System.out.print((char) character);
                character = fileReader.read();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
