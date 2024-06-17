package org.example.ex2.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketBooking {
    private int availableSeats;
    private final Lock lock = new ReentrantLock();

    public TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public synchronized void bookTicket(String threadName, int numberOfSeats) {
        if (numberOfSeats > availableSeats) {
            System.out.println(threadName + " - Not enough seats available.");
        } else {
            System.out.println(threadName + " - Successfully booked " + numberOfSeats + " seats.");
            availableSeats -= numberOfSeats;
        }
        System.out.println("----------------------------------------------");
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
