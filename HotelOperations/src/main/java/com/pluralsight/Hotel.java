package com.pluralsight;

public class Hotel {
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    /**
     * Constructor that initializes a hotel with no booked rooms
     * @param name Name of the hotel
     * @param numberOfSuites Total King Suites in hotel
     * @param numberOfRooms Total Basic Rooms in hotel
     */
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    /**
     * Constructor that initializes a hotel with some rooms already booked
     * @param name Name of the hotel
     * @param numberOfSuites Total King Suites in hotel
     * @param numberOfRooms Total Basic Rooms in hotel
     * @param bookedSuites Number of King Suites already booked
     * @param bookedBasicRooms Number of Basic Rooms already booked
     */
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    /**
     * Attempts to book a number of rooms of a specific type (suite or basic)
     * @param numberOfRooms Number of rooms to book
     * @param isSuite true for King Suite, false for Basic Room
     * @return true if booking was successful, false otherwise
     */
    public boolean bookRoom(int numberOfRooms, boolean isSuite) {
        if (isSuite) {
            if (numberOfRooms <= getAvailableSuites()) {
                bookedSuites += numberOfRooms;
                return true;
            }
        } else {
            if (numberOfRooms <= getAvailableBasicRooms()) {
                bookedBasicRooms += numberOfRooms;
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the number of King Suites available
     * @return available suites
     */
    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    /**
     * Gets the number of Basic Rooms available
     * @return available basic rooms
     */
    public int getAvailableBasicRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }
}
