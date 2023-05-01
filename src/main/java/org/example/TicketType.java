package org.example;

import java.util.Random;

/**
 * ENUM Class for the types of tickets
 */
public enum TicketType {

    FULL, FULLVIP, FREEPAS, ONEDAY, ONEDAYVIP;

    private static final Random ticket = new Random();

    /**
     * method which creates random tickets for attendees
     * @return
     */
    public static TicketType randomTicket () {
        TicketType[] ticketTypes = values();
        return ticketTypes[ticket.nextInt(ticketTypes.length)];
    }
}
