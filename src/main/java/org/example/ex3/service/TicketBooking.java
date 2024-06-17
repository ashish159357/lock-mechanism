package org.example.ex3.service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TicketBooking {

    private int availableSeats;
    private final Lock lock = new ReentrantLock();

    public TicketBooking(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public void bookTicket(String threadName, int numberOfSeats) {
        try{
            lock.lockInterruptibly();
            try {
                if (numberOfSeats > availableSeats) {
                    System.out.println(threadName + " - Not enough seats available.");
                } else {
                    System.out.println(threadName + " - Successfully booked " + numberOfSeats + " seats.");
                    availableSeats -= numberOfSeats;
                }
            } finally {
                lock.unlock();
                System.out.println("Lock is Realeases Successfully");
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for the lock.");
        }finally {
            System.out.println("----------------------------------------------");
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
