package com.pluralsight;
public class Reservation {
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;
    private double pricePerNight;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.isWeekend = isWeekend;
        this.pricePerNight = roomType.equals("king") ? 139.00 : 124.00;// ternary nested inside constructor
        if (isWeekend) {
            this.pricePerNight *= 1.10; // Increase price by 10% for weekends
        }
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return pricePerNight;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public double getReservationTotal() {
        return pricePerNight * numberOfNights;
    }
}
