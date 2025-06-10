import java.io.*;

public class Q7 {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            try (PrintWriter out = new PrintWriter(new FileWriter("error.log", true))) {
                out.println("Error: " + e.getMessage());
            } catch (IOException ex) {
                System.out.println("Log failed");
            }
        });

        int a = 5 / 0;
        System.out.println(a);
    }
}
