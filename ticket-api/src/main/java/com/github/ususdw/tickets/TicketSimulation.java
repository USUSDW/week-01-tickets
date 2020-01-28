package com.github.ususdw.tickets;

import java.util.Random;

public class TicketSimulation {

    private static final Random random = new Random();

    /**
     * Keeps track of our tickets.
     */
    private static final TicketQueue handler = new TicketQueue();

    /**
     * The number of trials to do.
     */
    private static final int trialCount = 10;

    /**
     * Drives a miniature version of what's expected in the tests.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        for(int i = 0; i < trialCount; i++) {
            var priority = Priority.fromInt(random.nextInt(21));
            var ticket = new Ticket(i, priority);
            handler.addToQueue(ticket);
        }
        for(int i = 0; i < trialCount; i++) {
            var ticket = handler.getNext();
            System.out.println(ticket.toString());
        }
    }
}
