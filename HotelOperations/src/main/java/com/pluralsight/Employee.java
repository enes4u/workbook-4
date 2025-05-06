package com.pluralsight;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private Double lastPunchTime; // variable to track last punch-in time
    private List<Double[]> punchRecords = new ArrayList<>(); // Stores punch-in and punch-out pairs
    private LocalDateTime lastPunchDateTime; // Last automatic punch-in time
    private List<LocalDateTime[]> dateTimePunches = new ArrayList<>(); // Automatic punch records

    public Employee(int employeeId, String name, String department, double payRate, Double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.lastPunchTime=null; // init punch time tracking null in the beginning
    }

    public double getTotalPay() {
        return getRegularHours() * payRate + getOvertimeHours() * (payRate * 1.5);
    }
    // Overloaded method: Calculates pay based on punch time card
    public double getTotalPay(boolean calculateFromPunch) {
        if (calculateFromPunch) {
            double punchHours = calculatePunchHours();
            double regular = Math.min(punchHours, 40);
            double overtime = Math.max(punchHours - 40, 0);
            return regular * payRate + overtime * payRate * 1.5;
        }
        return getTotalPay(); // Default calculation if not using punch records
    }

    public double getRegularHours() {
        return  Math.min(hoursWorked, 40); // Regular hours capped at 40
    }

    public double  getOvertimeHours() {
        return Math.max(hoursWorked - 40, 0); // Any extra hours beyond 40 are overtime
    }
///  this does not reflect to total pay because not constructed yet but will work on that tomorrow
    public void punchTimeCard(double time) {
        if (lastPunchTime == null) {
        // If currently not punched in, store punch-in time
        lastPunchTime = time;
        System.out.println(name + " punched in at " + time);
        } else {
        // If already punched in, calculate time worked and record punch pair
        double workedHours = time - lastPunchTime;
        hoursWorked += workedHours;
        punchRecords.add(new Double[]{lastPunchTime, time});
        System.out.println(name + " punched out at " + time + " (worked " + workedHours + " hours)");
        lastPunchTime = null; // Reset punch-in time for next session
        }
    }
    // Calculates total hours from punch-in and punch-out records
    private double calculatePunchHours() {
        double total = 0;
        for (Double[] punch : punchRecords) {
            total += punch[1] - punch[0];
        }
        return total;
    }

    /**
     * Automatically records punch-in using current time.
     */
    public void punchIn() {
        if (lastPunchDateTime == null) {
            lastPunchDateTime = LocalDateTime.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            System.out.println(name + " automatically punched in at " + lastPunchDateTime.format(formatter) + "\n"  );//+lastPunchDateTime
        } else {
            System.out.println(name + " is already punched in.");
        }
    }

    /**
     * Automatically records punch-out and saves duration.
     */
    public void punchOut() {
        if (lastPunchDateTime != null) {
            LocalDateTime punchOutTime = LocalDateTime.now();
            dateTimePunches.add(new LocalDateTime[]{lastPunchDateTime, punchOutTime}); // Save in/out pair

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            System.out.println(name + " automatically punched out at " +punchOutTime.format(formatter)+"\n" );//+punchOutTime
            lastPunchDateTime = null; // Reset
        } else {
            System.out.println(name + " has not punched in yet.");
        }
    }
    private double calculateAutoPunchHours() {
        double total = 0;
        for (LocalDateTime[] punch : dateTimePunches) {
            long minutes = java.time.Duration.between(punch[0], punch[1]).toMinutes();
            total += minutes / 60.0; // Convert minutes to fractional hours
        }
        return total;
    }

}
