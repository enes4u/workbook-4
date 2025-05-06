package com.pluralsight;

public class MainApp {

    public static void main(String[] args) {


        Room room1 = new Room(124.0, 2, false, false);
        Reservation reservation1 = new Reservation("king", 3, true);
        Employee employee1 = new Employee(101, "Topher Carter", "Undercover Boss", 10.00, 45.0);
        Employee employee2  = new Employee(102, "TEST 2 ","Accounting", 15, 10.0);
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
        employee2.punchTimeCard(10.0); // Punch in
        employee2.punchTimeCard(14.75); // Punch out
        System.out.println("Total hours worked: " + employee2.getRegularHours());
        System.out.println("--------------------------------------------------------");
        System.out.println("Total pay is "+employee2.getTotalPay());
        System.out.println("--------------------------------------------------------");
        System.out.println("Total Pay using punch time: $" + employee2.getTotalPay(true));

        Employee employee3 = new Employee(101, "Alice", "Front Desk", 20.0, 0.0);

        // Manual punch in/out with hour values
        employee3.punchTimeCard(9.0);  // Punch in at 9:00 AM
        employee3.punchTimeCard(17.0); // Punch out at 5:00 PM

        employee3.punchTimeCard(9.0);  // Next day punch in
        employee3.punchTimeCard(13.0); // Punch out after 4 hours

        System.out.println("Manual Punch Total Pay: $" + employee3.getTotalPay(true));

        // Simulate auto punch using system time (wait 1 sec between)
        employee3.punchIn();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        employee3.punchOut();

        System.out.println("Auto + Manual Punch Total Pay: $" + employee3.getTotalPay(true));

        // Regular fallback pay
        System.out.println("Total Pay using manual hoursWorked: $" + employee3.getTotalPay());


        // -------------------------------------------
        // Hotel Booking Tests
        // -------------------------------------------
        Hotel hotel = new Hotel("Grand Plaza", 10, 50);

        System.out.println("Hotel: " + hotel.getName());
        System.out.println("Available Suites: " + hotel.getAvailableSuites());
        System.out.println("Available Basic Rooms: " + hotel.getAvailableBasicRooms());

        boolean suiteBooked = hotel.bookRoom(3, true); // attempt to book 3 suites
        boolean roomBooked = hotel.bookRoom(5, false); // attempt to book 5 basic rooms

        System.out.println("Booked 3 Suites: " + suiteBooked);
        System.out.println("Booked 5 Basic Rooms: " + roomBooked);

        System.out.println("Available Suites after booking: " + hotel.getAvailableSuites());
        System.out.println("Available Basic Rooms after booking: " + hotel.getAvailableBasicRooms());



    }
}
