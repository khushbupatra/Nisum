import java.io.*;

public class Q5 {
    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                System.out.println(num);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readFile("numbers.txt");
    }
}
