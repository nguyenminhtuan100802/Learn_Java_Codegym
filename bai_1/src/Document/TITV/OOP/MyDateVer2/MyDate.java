package Document.TITV.OOP.MyDateVer2;

import java.util.Objects;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        }else {
            this.day = 1;
        }
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else {
            this.month = 1;
        }
        if (year >= 0) {
            this.year = year;
        } else {
            this.year = 1;
        }
    }
    public int getDay() {
        return  this.day;
    }
    public void setDay(int day) {
        if (day >= 1 && day <= 31) {
            this.day = day;
        }
    }
    public int getMonth() {
        return  this.month;
    }
    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
    }
    public int getYear() {
        return  this.year;
    }
    public void setYear(int year) {
        if (year >= 0) {
            this.year = year;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return this.day == myDate.day && this.month == myDate.month && this.year == myDate.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return "MyDate [day=" + day + ", month=" + month + ", year=" + year + "]";
    }

}
