package org.example;

/**
 * Blueprint class for creating a statistic object wich returns the sum of categories of tickets sold
 */
public class FestivalStatisticsThread extends Thread{
    private FestivalGate gate;

    public FestivalStatisticsThread(FestivalGate gate) {
        this.gate = gate;
    }

    /**
     * method for grouping the tickets and print them
     */
    public void run() {
        if(gate != null) {
        gate.showTicketsStats();

        try {
            sleep(5000);
        }catch ( InterruptedException e) {
            throw new RuntimeException(e);
        }

        }
        System.exit(1);
    }
}
