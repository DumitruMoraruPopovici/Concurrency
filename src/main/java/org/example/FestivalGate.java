package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.example.TicketType.*;

/**
 * Blueprint class for the festival gate, where tickets are stored and listed
 */
public class FestivalGate {
    List<TicketType> ticketsList = new ArrayList<>();

    public void addTicket (TicketType ticket) {
        ticketsList.add(ticket);
    }

    /**
     * method for sorting and printing the tickets by theyr type
     */
    public void showTicketsStats() {

        System.out.println("Total tikckets : " + ticketsList.size());
        System.out.println(Collections.frequency(ticketsList, FULL) + " have FULL tickets");
        System.out.println(Collections.frequency(ticketsList, FULLVIP) + " have FULLVIP passes");
        System.out.println(Collections.frequency(ticketsList, FREEPAS) + " have FREEPASS passes");
        System.out.println(Collections.frequency(ticketsList, ONEDAY) + " have ONEDAY passes");
        System.out.println(Collections.frequency(ticketsList, ONEDAYVIP) + " have ONEDAYVIP passes");

    }
}
