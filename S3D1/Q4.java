import java.io.*;

public class Q4 {
    public static void legacyApi() throws IOException {
        throw new IOException("Legacy error");
    }

    public static void wrappedMethod() {
        try {
            legacyApi();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void main(String[] args) {
        wrappedMethod();
    }
}
