package Document.Document_From_Teacher_Dao.Slide_1_3;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderStatement {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("Day: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Month: " + calendar.get(Calendar.MONTH));
        System.out.println("Year: " + calendar.get(Calendar.YEAR));

        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Date: " + simpleDateFormat.format(date));
    }
}
