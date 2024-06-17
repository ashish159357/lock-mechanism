package org.example.ex3;

import org.example.ex3.runnable.BookingTask;
import org.example.ex3.service.TicketBooking;

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

        // t1 will never goes in waiting as it first to enter in lock
        t1.interrupt();

        // other thread has to wait to lock release
        t2.interrupt();

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