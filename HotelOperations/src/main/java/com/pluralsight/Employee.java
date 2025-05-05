package com.pluralsight;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private int hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate, int hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
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
}
