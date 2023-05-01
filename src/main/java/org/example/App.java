package org.example;

import java.util.Random;

/**
 * every festival has a gate, where people have to show their tickets
 * write an application where every person is represented by a Thread that is instantiated with random ticket data
 * possible ticket types: full, full-vip, free-pass, one-day, one-day-vip
 * <p>
 * FestivalGate gate = new FestivalGate();
 * <p>
 * TicketType ticketType = // this should be an enum value randomly generated
 * <p>
 * FestivalAttendeeThread attendee = new FestivalAttendeeThread(ticketType, gate);
 * <p>
 * every attendee validates the ticket, and the ticket-data is kept is a queue
 * meanwhile, every 5 seconds a FestivalStatisticsThread wakes up and reads the new data from the gate and generates statistics
 * <p>
 * Subjects : FestivalGate, Ticket, TicketType(Enum) with random ticket,  attendee, person
 * Verbs : showTickets, generate,
 * <p>
 * e.g.
 * <p>
 * 100 people entered
 * <p>
 * 57 people have full tickets
 * <p>
 * 30 have free passes
 * <p>
 * 3 have full VIP passes
 * <p>
 * 10 have one-day passes
 * <p>
 * 0 have one-day VIP passes
 * <p>
 * FestivalStatisticsThread statisticsThread = new FestivalStatisticsThread(gate);
 * <p>
 * statsThread.start();
 * <p>
 * NOTES
 * <p>
 * there can be only one statisticsThread
 * statistics thread reads from the gate-data only if it's not empty
 * there can be unlimited attendee threads
 * attendee threads can add data to the gate regardless of the gate data being empty or full
 * the application must randomly generate multiple attendee threads - at least 100
 * use Thread.sleep in both thread types
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        /**
         * creating festival gate object
         */
        FestivalGate gate = new FestivalGate();
        /**
         * creating statistic object
         */
        FestivalStatisticsThread statsThread = new FestivalStatisticsThread(gate);
        /**
         * starting thread with object statistic
         */
        statsThread.start();
        /**
         * generating a number of random tickets for attendees
         */
        for(int i = 0; i<100; i++) {
            TicketType.randomTicket();
            FestivalAttendeeThread attendee = new FestivalAttendeeThread(TicketType.randomTicket(),gate);
            attendee.start();
            attendee.sleep(500);
            attendee.join();
        }
    }
}
