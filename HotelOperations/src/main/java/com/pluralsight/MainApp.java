package com.pluralsight;

public class MainApp {

    public static void main(String[] args) {
        Room room1 = new Room(124.00, 2, false, false);
        Reservation reservation1 = new Reservation("king", 3, true);
        Employee employee1 = new Employee(101, "Topher Carter", "Undercover Boss", 20.00, 45);

        System.out.println("Room available? " + room1.isAvailable());
        System.out.println("Reservation Total: $" + reservation1.getReservationTotal());
        System.out.println("Employee Pay: $" + employee1.getTotalPay());
    }
}
