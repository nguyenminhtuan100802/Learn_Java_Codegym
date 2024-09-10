package Youtube.TITV.OOP_Practice.Java61;

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
        for (int i = 0; i < this.studentArrayList.size(); i++) {
            System.out.println("Student " + (i + 1) + this.studentArrayList.get(i).toString());
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

}
