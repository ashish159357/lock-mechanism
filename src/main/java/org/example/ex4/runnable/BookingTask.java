package org.example.ex4.runnable;


import org.example.ex4.service.TicketBooking;

public class BookingTask implements Runnable {
    private final TicketBooking ticketBooking;
    private final int seatsToBook;

    public BookingTask(TicketBooking ticketBooking, int seatsToBook) {
        this.ticketBooking = ticketBooking;
        this.seatsToBook = seatsToBook;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        ticketBooking.bookTicket(threadName, seatsToBook);
    }
}
