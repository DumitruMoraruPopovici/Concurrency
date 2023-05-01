package org.example;

/**
 * Blueprint class for attendee
 */
public class FestivalAttendeeThread extends Thread{
    private TicketType ticketType;

    private FestivalGate gate;
    public FestivalAttendeeThread(TicketType ticketType, FestivalGate gate) {
        this.ticketType = ticketType;
        gate.addTicket(ticketType);
    }

    /**
     * method for ticketing attendee
     */
    public void run() {
        if (ticketType != null) {
            System.out.println("A new ticket " + ticketType + " is generated");
        }
    }
}
