package Document.TITV.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class WriteFile {
    public static void main(String[] args) {
        try {
            PrintWriter pw = new PrintWriter("E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\File\\testminhtuan\\vidu123.txt", StandardCharsets.UTF_8);
            pw.println("Hello 1231434341");
            pw.println();
            pw.println("data structure");
            pw.print("minh tuan");
            pw.println("123");

            Student student = new Student(123, "tuan", 18);
            pw.println(student);
            pw.flush();
            pw.close();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
