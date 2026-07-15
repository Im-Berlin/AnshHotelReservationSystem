import java.time.LocalDate;

/**
 * ---------------------------------------------------------
 * Booking.java
 * ---------------------------------------------------------
 * Represents a hotel room booking.
 * Stores customer details, room information,
 * booking date, payment amount and status.
 * ---------------------------------------------------------
 */

public class Booking {

    // Static variable to generate Booking IDs
    private static int bookingCounter = 1001;

    // Private Data Members
    private String bookingId;
    private String customerName;
    private Room room;
    private int numberOfNights;
    private double totalAmount;
    private LocalDate bookingDate;
    private String bookingStatus;

    /**
     * Parameterized Constructor
     */
    public Booking(String customerName, Room room, int numberOfNights) {

        this.bookingId = "BKG" + bookingCounter++;
        this.customerName = customerName;
        this.room = room;
        this.numberOfNights = numberOfNights;
        this.totalAmount = room.getPricePerNight() * numberOfNights;
        this.bookingDate = LocalDate.now();
        this.bookingStatus = "Confirmed";
    }

    // Getter Methods

    public String getBookingId() {
        return bookingId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    // Setter Methods

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    /**
     * Display Booking Details
     */
    @Override
    public String toString() {

        return "\n=========================================\n"
                + "           BOOKING DETAILS\n"
                + "=========================================\n"
                + "Booking ID      : " + bookingId + "\n"
                + "Customer Name   : " + customerName + "\n"
                + "Room Number     : " + room.getRoomNumber() + "\n"
                + "Room Type       : " + room.getRoomType() + "\n"
                + "Price/Night     : ₹" + room.getPricePerNight() + "\n"
                + "Number of Nights: " + numberOfNights + "\n"
                + "Booking Date    : " + bookingDate + "\n"
                + "Total Amount    : ₹" + totalAmount + "\n"
                + "Booking Status  : " + bookingStatus + "\n"
                + "=========================================";
    }
}