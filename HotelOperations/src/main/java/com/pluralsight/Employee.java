package com.pluralsight;

import java.util.*;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private Double lastPunchTime; // variable to track last punch-in time
    private List<Double[]> punchRecords = new ArrayList<>(); // Stores punch-in and punch-out pairs


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
        if (calculateFromPunch && lastPunchTime != null) {
            System.out.println("Calculating pay based on punch-in records.");
            return getRegularHours() * payRate + getOvertimeHours() * (payRate * 1.5);
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
    public void punchTimeCard(double time){
        if (lastPunchTime == null) {
            lastPunchTime = time;
            System.out.println(name + " punched in at " + time);
        } else {
            double workedHours = time - lastPunchTime;
            hoursWorked = 0;
            hoursWorked += workedHours;
            System.out.println(name + " punched out at " + time + " (worked " + workedHours + " hours)");
            lastPunchTime = null; // Reset punch time for next shift
        }
    }
}
