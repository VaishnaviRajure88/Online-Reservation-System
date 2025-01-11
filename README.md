# Task-1-Online-Reservation-System

# **Online Railway Reservation System**

## **Project Description**
The **Online Railway Reservation System** is a simple Java-based console application designed to manage train ticket bookings, cancellations, and reservation tracking. The project simulates real-world train reservation operations, offering an interactive experience for users to:

- View available trains and their seat availability.
- Book tickets by selecting trains and providing passenger details.
- Cancel booked tickets using a unique reservation ID.
- Display all active reservations.

## **Features**
- **View Available Trains:** Displays train details including train number, name, source, destination, and available seats.
- **Book Tickets:** Allows users to book tickets for available trains by entering train numbers and passenger information.
- **Cancel Tickets:** Enables ticket cancellation by entering the reservation ID.
- **View Reservations:** Lists all current reservations with passenger and train details.
  
## **Technologies Used**
- **Programming Language:** Java
- **Data Structures:** Lists and Maps for managing train data and reservations
- **User Input:** Command-line interface using `Scanner`
  
### **Prerequisites**
- Java Development Kit (JDK) 8 or higher
- A code editor or IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)

### **Installation**
1. Clone the repository:
   ```bash
   git clone https://github.com/VaishnaviRajure88/online-reservation-system.git
cd online-reservation-system

   ```

2. Compile the Java files:
   ```bash
   javac Train.java
    Reservation.java
    RailwayReservationSystem.java
   ```

3. Run the application:
   ```bash
   java RailwayReservationSystem
   ```

## **Project Structure**
```
online-reservation-system
│
├── Train.java                  // Class to represent train details and seat management
├── Reservation.java            // Class to handle reservation information
└── RailwayReservationSystem.java // Main class to run the application
```

## **How to Use**
1. Launch the program.
2. Follow the menu options displayed:
   - **1:** View available trains.
   - **2:** Book a ticket by entering train number and passenger name.
   - **3:** Cancel a ticket using the reservation ID.
   - **4:** View all reservations.
   - **5:** Exit the application.
  
## **Example Output**
```
Welcome to the Railway Reservation System!
Menu:
1. View Available Trains
2. Book Ticket
3. Cancel Ticket
4. View Reservations
5. Exit
Enter your choice:

