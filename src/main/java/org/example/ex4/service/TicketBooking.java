package org.example.ex4.service;

import java.util.concurrent.TimeUnit;
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
            if(lock.tryLock(1, TimeUnit.SECONDS)){
                try {
                    Thread.sleep(1000);
                    if (numberOfSeats > availableSeats) {
                        System.out.println(threadName + " - Not enough seats available.");
                    } else {
                        System.out.println(threadName + " - Successfully booked " + numberOfSeats + " seats.");
                        availableSeats -= numberOfSeats;
                    }
                } finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName() + " -> " + "Lock is Realeases Successfully");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire the lock and is doing something else.");
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for the lock.");
        }
    }

    public int getAvailableSeats() {
        return availableSeats;
    }
}
