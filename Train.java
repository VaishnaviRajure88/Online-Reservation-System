public class Train {
    private int trainNumber;
    private String trainName;
    private String source;
    private String destination;
    private int availableSeats;
    private final int totalSeats; // To ensure correct seat management

    public Train(int trainNumber, String trainName, String source, String destination, int availableSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.totalSeats = availableSeats;
    }

    public int getTrainNumber() { return trainNumber; }
    public String getTrainName() { return trainName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getAvailableSeats() { return availableSeats; }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        } else {
            System.out.println("No available seats to book!");
        }
    }

    public void cancelSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        } else {
            System.out.println("Error: Cannot cancel a seat beyond the available limit!");
        }
    }

    public void displayTrainInfo() {
        System.out.printf("%-10d %-20s %-15s %-15s %-10d\n",
                trainNumber, trainName, source, destination, availableSeats);
    }
}
