package Document.TITV.File;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("E:\\Github Frontend\\Java\\Learn_Java_Codegym\\bai_1\\src\\Youtube\\TITV\\File\\testminhtuan\\vidu123.txt");


        try {
            BufferedReader br = Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8);
            String line= null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
