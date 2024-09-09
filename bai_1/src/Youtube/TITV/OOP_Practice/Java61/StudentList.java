package Youtube.TITV.OOP_Practice.Java61;

import java.util.ArrayList;

public class StudentList {
    ArrayList<Student> studentArrayList;
    public StudentList() {
        this.studentArrayList = new ArrayList<Student>();
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
}
