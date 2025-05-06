package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private int hoursWorked;
    private Double lastPunchTime; // variable to track last punch-in time

    public Employee(int employeeId, String name, String department, double payRate, int hoursWorked) {
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

    public int getRegularHours() {
        return Math.min(hoursWorked, 40); // Regular hours capped at 40
    }

    public int getOvertimeHours() {
        return Math.max(hoursWorked - 40, 0); // Any extra hours beyond 40 are overtime
    }
///  this does not reflect to total pay because not constructed yet but will work on that tomorrow
    public void punchTimeCard(double time){
        if (lastPunchTime == null) {
            lastPunchTime = time;
            System.out.println(name + " punched in at " + time);
        } else {
            double workedHours = time - lastPunchTime;
            hoursWorked += workedHours;
            System.out.println(name + " punched out at " + time + " (worked " + workedHours + " hours)");
            lastPunchTime = null; // Reset punch time for next shift
        }
    }
}
