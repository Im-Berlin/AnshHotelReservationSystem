import java.util.Scanner;

/**
 * ---------------------------------------------------------
 * Main.java
 * ---------------------------------------------------------
 * Entry point of the Hotel Reservation System.
 * Handles user interaction through a menu-driven interface.
 * ---------------------------------------------------------
 */

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        int choice;

        do {

            System.out.println("\n================================================");
            System.out.println("         ANSH HOTEL RESERVATION SYSTEM");
            System.out.println("================================================");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View Booking Details");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Enter a number: ");
                scanner.next();
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {

                case 1:

                    hotel.displayAvailableRooms();
                    break;

                case 2:

                    System.out.print("\nEnter Customer Name : ");
                    String customerName = scanner.nextLine();

                    System.out.print("Enter Room Number   : ");
                    int roomNumber = scanner.nextInt();

                    System.out.print("Number of Nights    : ");
                    int nights = scanner.nextInt();

                    hotel.bookRoom(customerName, roomNumber, nights);

                    break;

                case 3:

                    System.out.print("\nEnter Room Number to Cancel Booking : ");
                    int cancelRoom = scanner.nextInt();

                    hotel.cancelBooking(cancelRoom);

                    break;

                case 4:

                    hotel.displayBookings();

                    break;

                case 5:

                    System.out.println("\n========================================");
                    System.out.println("Thank you for using");
                    System.out.println("🏨 Ansh Hotel Reservation System");
                    System.out.println("Have a great day!");
                    System.out.println("========================================");

                    break;

                default:

                    System.out.println("\nInvalid Choice! Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}