class Repository {
    public void fetchData() {
        throw new RuntimeException("Database error");
    }
}

class Service {
    Repository repo = new Repository();

    public void process() {
        repo.fetchData();
    }
}

public class Q10 {
    public static void main(String[] args) {
        Service service = new Service();
        try {
            service.process();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
