package Youtube.TITV.OOP_Practice.Java61;

import java.io.*;
import java.util.ArrayList;

public class StudentList {
    ArrayList<Student> studentArrayList;
    public StudentList() {
        this.studentArrayList = new ArrayList<Student>();
    }

    public int getListSize() {
        return this.studentArrayList.size();
    }
    public void addNewStudent(Student student) {
        this.studentArrayList.add(student);
    }
    public boolean isListEmpty() {
        return this.studentArrayList.isEmpty();
    }
    public void printStudents() {
        this.saveStudentsToFile();
        System.out.println("------------------ Student List ------------------");
        System.out.printf("%-5s %-20s %-15s %-10s %-15s %-15s%n",
                "ID", "Name", "Year of birth", "Score", "Username", "Password");
        for (int i = 0; i < this.studentArrayList.size(); i++) {
//            System.out.println("Student " + (i + 1) + this.studentArrayList.get(i).toString());
            System.out.printf("%-5s %-20s %-15s %-10s %-15s %-15s%n",
                    this.studentArrayList.get(i).getId(),
                    this.studentArrayList.get(i).getFullName(),
                    this.studentArrayList.get(i).getYearOfBirth(),
                    this.studentArrayList.get(i).getAverageScore(),
                    this.studentArrayList.get(i).getUserName(),
                    this.studentArrayList.get(i).getPassword());
        }
    }
    public void ClearAllStudents(){
        this.studentArrayList.clear();
    }
    public void findStudentsByID(String id) {
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getId().equals(id)) {
                isFound = true;
                System.out.println("Student " + (i + 1) + this.studentArrayList.get(i).toString());
            }
        }
        if (!isFound) {
            System.out.println("Student " + id + " not found");
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

    public void findStudentsByName(String name) {
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getFullName().equals(name)) {
                isFound = true;
                System.out.println("Student " + (i + 1) + this.studentArrayList.get(i).toString());
            }
        }
        if (!isFound) {
            System.out.println("Student " + name + " not found");
        }
    }

    public void findStudentsByYearOfBirth(int yearOfBirth) {
        boolean isFound = false;
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            if (this.studentArrayList.get(i).getYearOfBirth() == yearOfBirth) {
                isFound = true;
                System.out.println("Student " + (i + 1) + this.studentArrayList.get(i).toString());
            }
        }
        if (!isFound) {
            System.out.println("Student " + yearOfBirth + " not found");
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
    public void sortAscendingByScore(){
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            for (int j = i + 1; j < this.studentArrayList.size(); j++) {
                if (studentArrayList.get(i).getAverageScore() > studentArrayList.get(j).getAverageScore()) {
                    Student temp = studentArrayList.get(i);
                    studentArrayList.set(i, studentArrayList.get(j));
                    studentArrayList.set(j, temp);
                }
            }
        }
    }
    public void sortDescendingByScore(){
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            for (int j = i + 1; j < this.studentArrayList.size(); j++) {
                if (studentArrayList.get(i).getAverageScore() < studentArrayList.get(j).getAverageScore()) {
                    Student temp = studentArrayList.get(i);
                    studentArrayList.set(i, studentArrayList.get(j));
                    studentArrayList.set(j, temp);
                }
            }
        }
    }

    public void saveStudentsToFile(){
        try {
            File file = new File("E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\OOP_Practice\\Java61\\file.data");
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

//            Student student = new Student("1", "tuan", 2000, 9);
//            objectOutputStream.writeObject(student);
            for (int i = 0; i < this.studentArrayList.size(); i++) {
                objectOutputStream.writeObject(studentArrayList.get(i));
            }
            objectOutputStream.flush();
            objectOutputStream.close();

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void loadStudentsFromFile() {
        File file = new File("E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\OOP_Practice\\Java61\\file.data");

        // Kiểm tra xem tệp có tồn tại hay không
        if (!file.exists()) {
            System.out.println("File not found, creating a new file.");
            try {
                // Tạo thư mục chứa tệp nếu nó không tồn tại
                file.getParentFile().mkdirs();
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getPath());
                } else {
                    System.out.println("Failed to create file: " + file.getPath());
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        // Đọc tệp nếu tệp tồn tại
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    // Đọc từng đối tượng từ file
                    Object object = objectInputStream.readObject();
                    if (object instanceof Student) {
                        Student student = (Student) object;
                        studentArrayList.add(student);
                    }
                } catch (EOFException e) {
                    // Đã đọc hết file, thoát khỏi vòng lặp
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    public void loadStudentsFromFile(){
//        File file = new File("E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\OOP_Practice\\Java61\\file.data");
//        if (!file.exists()) {
//            System.out.println("File not found, creating a new file: ");
//            // Tạo tệp nếu nó không tồn tại
//            try {
//                if (file.createNewFile()) {
//                    System.out.println("File created: ");
//                } else {
//                    System.out.println("Failed to create file: ");
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                return;
//            }
//        }
//
//        // Tiếp tục với quá trình đọc tệp nếu tệp tồn tại
//        try (FileInputStream fis = new FileInputStream(file);
//             ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {
//
//            Student student = null;
//            while (true){
//                Object object = objectInputStream.readObject();
//                if (object == null){
//                    break;
//                }
//                if (object != null){
//                    student = (Student) object;
//                    this.studentArrayList.add(student);
//                }
//
//            }
//
//            objectInputStream.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found: ");
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
////        try {
////            InputStream inputStream = new FileInputStream(file);
////            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
////
////            Student student = null;
////            while (true){
////                Object object = objectInputStream.readObject();
////                if (object == null){
////                    break;
////                }
////                if (object != null){
////                    student = (Student) object;
////                    this.studentArrayList.add(student);
////                }
////
////            }
////
////            objectInputStream.close();
////
////
////        } catch (IOException | ClassNotFoundException e) {
////            throw new RuntimeException(e);
////        }
//    }
}
