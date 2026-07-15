/**
 * ---------------------------------------------------------
 * Room.java
 * ---------------------------------------------------------
 * Represents a hotel room.
 * Stores room information such as room number,
 * room type, price and availability.
 * ---------------------------------------------------------
 */

public class Room {

    // Private data members
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;

    /**
     * Parameterized Constructor
     *
     * @param roomNumber Room Number
     * @param roomType Room Category
     * @param pricePerNight Price Per Night
     */
    public Room(int roomNumber, String roomType, double pricePerNight) {

        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    // Getter for Room Number
    public int getRoomNumber() {
        return roomNumber;
    }

    // Setter for Room Number
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    // Getter for Room Type
    public String getRoomType() {
        return roomType;
    }

    // Setter for Room Type
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    // Getter for Price
    public double getPricePerNight() {
        return pricePerNight;
    }

    // Setter for Price
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    // Getter for Availability
    public boolean isAvailable() {
        return isAvailable;
    }

    // Setter for Availability
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * Returns room details
     */
    @Override
    public String toString() {

        return String.format(
                "%-10d %-15s ₹%-10.2f %-10s",
                roomNumber,
                roomType,
                pricePerNight,
                isAvailable ? "Available" : "Booked");
    }
}