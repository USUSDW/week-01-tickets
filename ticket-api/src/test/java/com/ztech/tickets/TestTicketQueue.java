package com.ztech.tickets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

public class TestTicketQueue {
    private TicketQueue queue;

    @Before
    public void setUp() {
        queue = new TicketQueue();
    }

    @Test
    public void addAndRemove() {
        var ticket = new Ticket(1, Priority.LOW);
        queue.addToQueue(ticket);
        assertEquals(ticket, queue.getNext());
    }

    @Test
    public void noEmptyRemove() {
        assertNull(queue.getNext());
    }

    @Test
    public void simpleTest() {
        var important = new Ticket(1, Priority.IMPORTANT);
        var high = new Ticket(2, Priority.HIGH);
        var medium1 = new Ticket(3, Priority.MEDIUM);
        var medium2 = new Ticket(4, Priority.MEDIUM);
        var low = new Ticket(5, Priority.LOW);

        queue.addToQueue(important);
        queue.addToQueue(high);
        queue.addToQueue(medium1);
        queue.addToQueue(medium2);
        queue.addToQueue(low);

        assertEquals(important, queue.getNext());
        assertEquals(high, queue.getNext());
        assertEquals(medium1, queue.getNext());
        assertEquals(medium2, queue.getNext());
        assertEquals(low, queue.getNext());
    }

    @Test
    public void outOfOrderTest() {
        var important = new Ticket(1, Priority.IMPORTANT);
        var high = new Ticket(2, Priority.HIGH);
        var medium1 = new Ticket(3, Priority.MEDIUM);
        var medium2 = new Ticket(4, Priority.MEDIUM);
        var low = new Ticket(5, Priority.LOW);

        queue.addToQueue(low);
        queue.addToQueue(important);
        queue.addToQueue(medium2);
        queue.addToQueue(high);
        queue.addToQueue(medium1);

        assertEquals(important, queue.getNext());
        assertEquals(high, queue.getNext());
        assertEquals(medium1, queue.getNext());
        assertEquals(medium2, queue.getNext());
        assertEquals(low, queue.getNext());
    }

    @Test
    public void randomTest() {
        PriorityQueue<Ticket> pq = new PriorityQueue<>(Comparator.comparingInt(ticket -> ticket.priority.priority));
        Random random = new Random();

        for(int i = 0; i < 1000; i++) {
            var priority = Priority.fromInt(random.nextInt(21));
            var ticket = new Ticket(i, priority);
            pq.add(ticket);
            queue.addToQueue(ticket);
        }
        for(int i = 0; i < 1000; i++) {
            var ticket = queue.getNext();
            assertEquals(pq.poll(), ticket);
        }
    }

}
