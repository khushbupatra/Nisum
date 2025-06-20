package com.nisum;

class UserDAO {
    public void fetchUserFromDB() {
        throw new RuntimeException("Database connection failed.");
    }
}


class UserService {
    UserDAO dao = new UserDAO();

    public void processUser() {
        dao.fetchUserFromDB();
    }
}

public class Q10 {
    public static void main(String[] args) {
        UserService service = new UserService();

        try {
            service.processUser();
        } catch (RuntimeException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}

