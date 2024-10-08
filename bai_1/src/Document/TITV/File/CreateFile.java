package Document.TITV.File;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void main(String[] args) {
        File folder = new File("E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\File\\testminhtuan");
        System.out.println("Folder exists: " + folder.exists());
//        create folder
        folder.mkdir();
        File file = new File("E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\File\\testminhtuan\\vidu.txt");
        try {
            file.createNewFile();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
