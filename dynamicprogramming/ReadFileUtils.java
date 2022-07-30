package dynamicprogramming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileUtils {

    final static String file = "dynamicprogramming/input.txt";

    public static int[] readLineAsIntArray(int line) {

        String currentLine = null;
        try {
            currentLine = Files.readAllLines(Paths.get(file)).get(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] s = currentLine.split(" ");

        int[] values = Stream.of(s)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("read int of array"+values.length);
        return values;
    }

    public static int readLineAsInt(int line)  {

        String currentLine = null;
        try {
            currentLine = Files.readAllLines(Paths.get(file)).get(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] s = currentLine.split(" ");

        int[] values = Stream.of(s)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println("read int of array"+values.length);
        return values[0];
    }
}
