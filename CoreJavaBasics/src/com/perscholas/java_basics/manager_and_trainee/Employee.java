package com.perscholas.java_basics.manager_and_trainee;

public abstract class Employee {

    long employeeId;
    String employeeName;
    String employeeAddress;
    Long employeePhone;
    double basicSalary;
    double specialAllowance = 250.80d;
    double hra = 1000.50d;

    Employee(long id, String name, String address, Long phone) {
        employeeId = id;
        employeeName = name;
        employeeAddress = address;
        employeePhone = phone;
    }

    public double calculateSalary() {
        return basicSalary + (basicSalary * specialAllowance/100) + (basicSalary * hra/100);
    }

    public double calculateTransportAllowance() {
        return 0.1D * basicSalary;
    }
}
