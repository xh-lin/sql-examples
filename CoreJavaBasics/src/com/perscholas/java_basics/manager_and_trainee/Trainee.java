package com.perscholas.java_basics.manager_and_trainee;

public class Trainee extends Employee {

    Trainee(long id, String name, String address, Long phone, double salary) {
        super(id, name, address, phone);
        basicSalary = salary;
    }
    
}
