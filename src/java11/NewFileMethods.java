package java11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewFileMethods {
    public static void main(String[] args) throws IOException {

        Path path = Files.writeString(
                Path.of("/home/jimsa/Desktop", "demo.txt"),
                "sample text \n to write"
        );

        String fileContent = Files.readString(path);
        System.out.println(fileContent);

    }
}
