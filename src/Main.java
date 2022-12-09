import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Charset charset = StandardCharsets.UTF_8;
        byte [] b = "Ы".getBytes(charset);
        int [] result = new int[b.length];
        for (int i = 0; i < b.length; i++) {
            result [i] = Byte.toUnsignedInt(b [i]);
        }
        System.out.print(Arrays.toString(result));

        }
    }




