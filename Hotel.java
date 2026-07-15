import java.util.ArrayList;

/**
 * ---------------------------------------------------------
 * Hotel.java
 * ---------------------------------------------------------
 * Handles all hotel operations including
 * room management, booking, cancellation,
 * payment simulation and reservation details.
 * ---------------------------------------------------------
 */

public class Hotel {

    // Store Rooms
    private ArrayList<Room> rooms;

    // Store Bookings
    private ArrayList<Booking> bookings;

    /**
     * Constructor
     */
    public Hotel() {

        rooms = new ArrayList<>();
        bookings = new ArrayList<>();

        initializeRooms();
    }

    /**
     * Creates default hotel rooms
     */
    private void initializeRooms() {

        rooms.add(new Room(101, "Standard", 1500));
        rooms.add(new Room(102, "Standard", 1500));

        rooms.add(new Room(201, "Deluxe", 2500));
        rooms.add(new Room(202, "Deluxe", 2500));

        rooms.add(new Room(301, "Suite", 5000));
    }

    /**
     * Display all rooms
     */
    public void displayAvailableRooms() {

        System.out.println("\n==============================================================");
        System.out.printf("%-10s %-15s %-15s %-15s\n",
                "Room No", "Type", "Price", "Status");
        System.out.println("==============================================================");

        for (Room room : rooms) {

            System.out.printf("%-10d %-15s ₹%-14.2f %-15s\n",
                    room.getRoomNumber(),
                    room.getRoomType(),
                    room.getPricePerNight(),
                    room.isAvailable() ? "Available" : "Booked");
        }

        System.out.println("==============================================================");
    }

    /**
     * Find room by room number
     */
    private Room findRoom(int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {
                return room;
            }

        }

        return null;
    }

    /**
     * Book a room
     */
    public void bookRoom(String customerName,
                         int roomNumber,
                         int nights) {

        Room room = findRoom(roomNumber);

        if (room == null) {

            System.out.println("\n❌ Room not found.");
            return;
        }

        if (!room.isAvailable()) {

            System.out.println("\n❌ Room already booked.");
            return;
        }

        room.setAvailable(false);

        Booking booking =
                new Booking(customerName, room, nights);

        bookings.add(booking);

        System.out.println("\n======================================");
        System.out.println("       PAYMENT SUMMARY");
        System.out.println("======================================");
        System.out.println("Customer : " + customerName);
        System.out.println("Room     : " + room.getRoomType());
        System.out.println("Amount   : ₹" + booking.getTotalAmount());
        System.out.println("--------------------------------------");
        System.out.println("✅ Payment Successful!");
        System.out.println("======================================");

        System.out.println("\n🎉 Booking Confirmed!");

        System.out.println(booking);
    }

    /**
     * Cancel Booking
     */
    public void cancelBooking(int roomNumber) {

        for (Booking booking : bookings) {

            if (booking.getRoom().getRoomNumber() == roomNumber
                    && booking.getBookingStatus().equals("Confirmed")) {

                booking.setBookingStatus("Cancelled");

                booking.getRoom().setAvailable(true);

                System.out.println("\n✅ Booking Cancelled Successfully!");

                return;
            }

        }

        System.out.println("\n❌ No active booking found.");
    }

    /**
     * Display all bookings
     */
    public void displayBookings() {

        if (bookings.isEmpty()) {

            System.out.println("\nNo bookings available.");
            return;
        }

        for (Booking booking : bookings) {

            System.out.println(booking);
        }
    }

    /**
     * Total Bookings
     */
    public int getTotalBookings() {

        return bookings.size();
    }

}