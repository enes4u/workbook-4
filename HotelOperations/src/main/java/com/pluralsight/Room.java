package com.pluralsight;

public class Room {
    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(double price, int numberOfBeds, boolean occupied, boolean dirty) {
        this.price = price;
        this.numberOfBeds = numberOfBeds;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
    public boolean isAvailable() {
        return !occupied && !dirty;
    }
    public void checkIn(){
        if (isAvailable()){
            occupied = true;
            dirty=true;  ///room marked dirty upon check-in
        } else {
            System.out.println("Room is not available for check-in");
        }
    }

    public void checkOut(){
        if(occupied){
            occupied=false;
            System.out.println("Guest has checked out. Room needs to be cleaned.");
        }else {
            System.out.println("Room is already vacant. ");
        }
    }
    public void cleanRoom(){
        if (!occupied){
            dirty=false;
            System.out.println("Room has been cleaned and is now available");
        } else {
            System.out.println("Room cannot be cleaned while occupied. ");
        }
    }
}
