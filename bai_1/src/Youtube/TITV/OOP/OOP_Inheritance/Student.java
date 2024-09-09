package Youtube.TITV.OOP.OOP_Inheritance;

public class Student extends People{
    private String className;
    private String schoolName;

    public Student(String fullName, int yearOfBirth, String className, String schoolName) {
        super(fullName, yearOfBirth);
        this.className = className;
        this.schoolName = schoolName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public void doHomework(){
        System.out.println("Do homework");
    }
}
