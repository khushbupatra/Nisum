package com.nisum;

class TicketBookingSystem {
    int availableTickets = 3;

    public synchronized void bookTicket(String name, int ticketsToBook) {
        if (ticketsToBook <= availableTickets) {
            System.out.println(name + " booked " + ticketsToBook + " ticket(s)");
            availableTickets -= ticketsToBook;
        } else {
            System.out.println(name + " tried to book " + ticketsToBook + " ticket(s), but not enough tickets available");
        }
    }
}

public class Q23 {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        Thread user1 = new Thread(() -> bookingSystem.bookTicket("User1", 2));
        Thread user2 = new Thread(() -> bookingSystem.bookTicket("User2", 2));
        Thread user3 = new Thread(() -> bookingSystem.bookTicket("User3", 1));

        user1.start();
        user2.start();
        user3.start();
    }
}
