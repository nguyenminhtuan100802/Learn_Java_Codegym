package Youtube.TITV.OOP.MyDate;

public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void printDay(){
        System.out.println("Day: " + this.day);
    }
    public void printMonth(){
        System.out.println("Month: " + this.month);
    }
    public void printYear(){
        System.out.println("Year: " + this.year);
    }
    public void printDate(){
        System.out.println("Date: " + this.day + "-" + this.month + "-" + this.year);
    }
}
