package org.example;

public class Main {
    public static void main(String[] args) {
        TicketBooking ticketBooking = new TicketBooking(10);

        Thread t1 = new Thread(new BookingTask(ticketBooking, 4), "Thread-1");
        Thread t2 = new Thread(new BookingTask(ticketBooking, 2), "Thread-2");
        Thread t3 = new Thread(new BookingTask(ticketBooking, 5), "Thread-3");
        Thread t4 = new Thread(new BookingTask(ticketBooking, 3), "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final available seats: " + ticketBooking.getAvailableSeats());
    }
}