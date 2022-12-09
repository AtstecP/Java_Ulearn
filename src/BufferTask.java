import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BufferTask {
    public static String readFile(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    public static void refactorFile() {
        String content = null;
        try {
            content = readFile("File.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < content.length(); i++) {
            if (!Character.isDigit(content.charAt(i))) {
                str.append(content.charAt(i));
            }
        }
        try {
            FileWriter myWriter = new FileWriter("newFile.txt");
            myWriter.write(str.toString());
            myWriter.close();
        } catch (IOException e) {
        }
    }
}