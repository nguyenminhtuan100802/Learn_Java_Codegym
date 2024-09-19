package Youtube.TITV.OOP_Practice.Java61.main;

import Youtube.TITV.OOP_Practice.Java61.application.Application;
import Youtube.TITV.OOP_Practice.Java61.user.Admin;
import Youtube.TITV.OOP_Practice.Java61.choice.*;
import Youtube.TITV.OOP_Practice.Java61.menu.MenuAdmin;
import Youtube.TITV.OOP_Practice.Java61.user.Student;
import Youtube.TITV.OOP_Practice.Java61.user.StudentList;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Application.runApplication();
        saveStudentsToFile();
        loadStudentsFromFile();

    }
    public static void saveStudentsToFile(){
        try {
            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\OOP_Practice\\Java61\\mini_database\\students.csv";
            FileWriter fileWriter = new FileWriter(fileName);
            Student student = new Student("123", "minh tuan", 2002, 10, "tuan123", "tuan123");

            fileWriter.write(student.getId() + "-");
            fileWriter.write(student.getFullName() + "-");
            fileWriter.write(student.getYearOfBirth() + "-");
            fileWriter.write(student.getAverageScore() + "-");
            fileWriter.write(student.getAccount().getUserName() + "-");
            fileWriter.write(student.getAccount().getPassword() + "|\n");

            Student student1 = new Student("456", "con heo", 2001, 9, "conheo123", "conheo123");

            fileWriter.write(student1.getId() + "-");
            fileWriter.write(student1.getFullName() + "-");
            fileWriter.write(student1.getYearOfBirth() + "-");
            fileWriter.write(student1.getAverageScore() + "-");
            fileWriter.write(student1.getAccount().getUserName() + "-");
            fileWriter.write(student1.getAccount().getPassword() + "|");

            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void loadStudentsFromFile() {
        try {
            int count = 0;
            String id = "";
            String fullName = "";
            String yearOfBirth = "";
            String averageScore = "";
            String userName = "";
            String password = "";


            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\OOP_Practice\\Java61\\mini_database\\students.csv";
            FileReader fileReader = new FileReader(fileName);
            while (true){
                int character = fileReader.read();
                System.out.print((char) character);
                if (character == -1){
                    break;
                }
                if ((char)character == '-'){
                    count++;

                }
                if (count == 0 && (char)character != '-' && (char)character != '\n'){
                    id += (char)character;
                }
                else if (count == 1 && (char)character != '-'){
                    fullName += (char)character;
                }
                else if (count == 2 && (char)character != '-'){
                    yearOfBirth += (char)character;
                }
                else if (count == 3 && (char)character != '-'){
                    averageScore += (char)character;
                }
                else if (count == 4 && (char)character != '-'){
                    userName += (char)character;
                }
                else if (count == 5 && (char)character != '-' && (char)character != '|'){
                    password += (char)character;
                }
                if ((char)character == '|'){
                    System.out.println();
                    System.out.println("ID: " + id);
                    System.out.println("Full Name: " + fullName);
                    System.out.println("Year of Birth: " + yearOfBirth);
                    System.out.println("Average Score: " + averageScore);
                    System.out.println("User Name: " + userName);
                    System.out.println("Password: " + password);

                    Student student = new Student(id, fullName, Integer.parseInt(yearOfBirth), Double.parseDouble(averageScore), userName, password);
                    System.out.println(student.toString());

                    count = 0;
                    id = "";
                    fullName = "";
                    yearOfBirth = "";
                    averageScore = "";
                    userName = "";
                    password = "";
                }
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
