import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RailwayReservationSystem {
    private static final List<Train> trainList = new ArrayList<>();
    private static final Map<Integer, Reservation> reservations = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int reservationIdCounter = 1;

    public static void main(String[] args) {
        initializeTrains();
        int choice;

        System.out.println("Welcome to the Railway Reservation System!");
        do {
            displayMenu();
            choice = getUserChoice();
            handleUserChoice(choice);
        } while (choice != 5);

        System.out.println("Thank you for using the Railway Reservation System!");
    }

    private static void initializeTrains() {
        trainList.add(new Train(101, "Express 1", "Mumbai", "Pune", 50));
        trainList.add(new Train(102, "Express 2", "Delhi", "Agra", 60));
        trainList.add(new Train(103, "Express 3", "Chennai", "Bangalore", 55));
        trainList.add(new Train(104, "Express 4", "Kolkata", "Patna", 40));
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. View Available Trains");
        System.out.println("2. Book Ticket");
        System.out.println("3. Cancel Ticket");
        System.out.println("4. View Reservations");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number between 1 and 5.");
            scanner.next();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    private static void handleUserChoice(int choice) {
        switch (choice) {
            case 1 -> viewAvailableTrains();
            case 2 -> bookTicket();
            case 3 -> cancelTicket();
            case 4 -> viewReservations();
            case 5 -> {}
            default -> System.out.println("Invalid choice! Please try again.");
        }
    }

    private static void viewAvailableTrains() {
        System.out.println("\nAvailable Trains:");
        System.out.printf("%-10s %-20s %-15s %-15s %-10s\n", "Train No", "Train Name", "Source", "Destination", "Seats");
        for (Train train : trainList) {
            train.displayTrainInfo();
        }
    }

    private static void bookTicket() {
        System.out.print("Enter Train Number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); 
        Train selectedTrain = findTrainByNumber(trainNumber);

        if (selectedTrain == null) {
            System.out.println("Train not found! Please enter a valid train number.");
            return;
        }

        if (selectedTrain.getAvailableSeats() > 0) {
            System.out.print("Enter Passenger Name: ");
            String passengerName = scanner.nextLine().trim();

            if (passengerName.isEmpty()) {
                System.out.println("Passenger name cannot be empty!");
                return;
            }

            Reservation reservation = new Reservation(reservationIdCounter++, passengerName, selectedTrain);
            reservations.put(reservation.getReservationId(), reservation);
            selectedTrain.bookSeat();

            System.out.println("Ticket booked successfully! Reservation ID: " + reservation.getReservationId());
        } else {
            System.out.println("No seats available on this train.");
        }
    }

    private static Train findTrainByNumber(int trainNumber) {
        for (Train train : trainList) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        return null;
    }

    private static void cancelTicket() {
        System.out.print("Enter Reservation ID: ");
        int reservationId = scanner.nextInt();

        if (reservations.containsKey(reservationId)) {
            Reservation reservation = reservations.remove(reservationId);
            reservation.getTrain().cancelSeat();
            System.out.println("Ticket cancelled for: " + reservation.getPassengerName());
        } else {
            System.out.println("Invalid Reservation ID!");
        }
    }

    private static void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations.values()) {
                System.out.println(reservation);
            }
        }
    }
}
