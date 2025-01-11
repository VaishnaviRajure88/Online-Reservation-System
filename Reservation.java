    // Handles booking and cancellation of tickets
public class Reservation {
    private int reservationId;
    private String passengerName;
    private Train train;

    public Reservation(int reservationId, String passengerName, Train train) {
        this.reservationId = reservationId;
        this.passengerName = passengerName;
        this.train = train;
    }

    public int getReservationId() { return reservationId; }
    public String getPassengerName() { return passengerName; }
    public Train getTrain() { return train; }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + 
               ", Passenger: " + passengerName + 
               ", Train: " + train.getTrainName();
    }
}
