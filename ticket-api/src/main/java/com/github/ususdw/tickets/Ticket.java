package com.ztech.tickets;

import java.util.Date;

/**
 *
 */
public class Ticket {

    /**
     * The ID of this ticket. Increments with each ticket created.
     */
    public final int id;

    /**
     * The priority of this ticket.
     */
    public final Priority priority;

    /**
     * The priority of this ticket.
     */
    public final String subject;

    /**
     * When this ticket was created.
     */
    public final Date createdOn;

    /**
     * Builds a Ticket with the given ID and priority.
     *
     * @param id The ID of this ticket. For reference purposes only.
     * @param priority The priority of this ticket.
     */
    public Ticket(int id, Priority priority) {
        this(id, priority, "");
    }

    public Ticket(int id, Priority priority, String subject) {
        this.id = id;
        this.priority = priority;
        this.subject = subject;
        this.createdOn = new Date();
    }

    /**
     * Formats our ticket into something that's nice and readable.
     *
     * @return The formatted ticket.
     */
    @Override
    public String toString() {
        return "Ticket " + id + " (" + priority + ")";
    }
}
