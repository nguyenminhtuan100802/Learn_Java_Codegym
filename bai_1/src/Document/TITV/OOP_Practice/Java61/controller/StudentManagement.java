package Document.TITV.OOP_Practice.Java61.controller;

import Document.TITV.OOP_Practice.Java61.service.StudentService;

public class StudentManagement {
    private final StudentService studentService;
    public StudentManagement() {
        this.studentService = new StudentService();
    }

    public StudentService getStudentService() {
        return studentService;
    }
}
