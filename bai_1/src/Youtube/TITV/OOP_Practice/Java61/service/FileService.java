package Youtube.TITV.OOP_Practice.Java61.service;

import Youtube.TITV.OOP_Practice.Java61.model.Student;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileService {
    public static void saveStudentsToFile(ArrayList<Student> studentArrayList) {
        try {
            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\OOP_Practice\\Java61\\repository\\students.csv";
            FileWriter fileWriter = new FileWriter(fileName);
            for (int i = 0; i < studentArrayList.size(); i++) {
                fileWriter.write(studentArrayList.get(i).getId() + "-");
                fileWriter.write(studentArrayList.get(i).getFullName() + "-");
                fileWriter.write(studentArrayList.get(i).getYearOfBirth() + "-");
                fileWriter.write(studentArrayList.get(i).getAverageScore() + "-");
                fileWriter.write(studentArrayList.get(i).getAccount().getUserName() + "-");
                fileWriter.write(studentArrayList.get(i).getAccount().getPassword() + "|\n");
            }
            fileWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Student> loadStudentsFromFile() {
        int count = 0;
        String id = "";
        String fullName = "";
        String yearOfBirth = "";
        String averageScore = "";
        String userName = "";
        String password = "";
        ArrayList<Student> listStudents = new ArrayList<Student>();

        try {
            System.out.println("test 123");

            String fileName = "E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\OOP_Practice\\Java61\\repository\\students.csv";
            FileReader fileReader = new FileReader(fileName);
            while (true){
                int character = fileReader.read();
//                System.out.print((char) character);
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
//                    System.out.println();
//                    System.out.println("ID: " + id);
//                    System.out.println("Full Name: " + fullName);
//                    System.out.println("Year of Birth: " + yearOfBirth);
//                    System.out.println("Average Score: " + averageScore);
//                    System.out.println("User Name: " + userName);
//                    System.out.println("Password: " + password);

                    listStudents.add(new Student(id, fullName, Integer.parseInt(yearOfBirth), Double.parseDouble(averageScore), userName, password));

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
        return listStudents;
    }
}
