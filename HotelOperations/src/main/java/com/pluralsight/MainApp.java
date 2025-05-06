package com.pluralsight;

public class MainApp {

    public static void main(String[] args) {
        Room room1 = new Room(124.0, 2, false, false);
        Reservation reservation1 = new Reservation("king", 3, true);
        Employee employee1 = new Employee(101, "Topher Carter", "Undercover Boss", 10.00, 45);

        System.out.println("Room available? " + room1.isAvailable());
        System.out.println("Reservation Total: $" + reservation1.getReservationTotal());
        System.out.println("Employee Pay: $" + employee1.getTotalPay());
        System.out.println("--------------------------------------------------------");

        System.out.println("Room available? " + room1.isAvailable());
        System.out.println("--------------------------------------------------------");
        // Testing room operations
        room1.checkIn();
        System.out.println("Is room dirty? " + room1.isDirty());
        System.out.println("--------------------------------------------------------");
        room1.checkOut();
        room1.cleanRoom();
        System.out.println("Room available after cleaning? " + room1.isAvailable());
        System.out.println("--------------------------------------------------------");


        // Testing employee operations
        employee1.punchTimeCard(10.0); // Punch in
        employee1.punchTimeCard(14.75); // Punch out
        System.out.println("Total hours worked: " + employee1.getRegularHours());
        System.out.println("--------------------------------------------------------");
        System.out.println("Total pay is "+employee1.getTotalPay());

    }
}
