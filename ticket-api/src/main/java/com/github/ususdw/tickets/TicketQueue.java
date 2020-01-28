package com.github.ususdw.tickets;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Manages a queue of tickets. Each can be assigned a priority. The order they come back is up to
 * the implementation of this class.
 */
public class TicketQueue {

    //TODO: Update me!
    /** Holds all of our tickets. The first ones are the most important. */
    private Queue<Ticket> ticketQueue = new LinkedList<>();

    /**
     * Adds a ticket to the queue.
     *
     * @param ticket The ticket to add to the queue.
     */
    public void addToQueue(Ticket ticket) {
        //TODO: Update me!
        ticketQueue.add(ticket);
    }

    /**
     * Gets the next ticket off of the queue.
     *
     * @return The next ticket off of the queue.
     */
    public Ticket getNext() {
        //TODO: Update me!
        return ticketQueue.poll();
    }

    /**
     * Shows what the next ticket will be without removing it from the queue.
     *
     * @return What the next ticket will be.
     */
    public Ticket peekNext() {
        return ticketQueue.peek();
    }
}
