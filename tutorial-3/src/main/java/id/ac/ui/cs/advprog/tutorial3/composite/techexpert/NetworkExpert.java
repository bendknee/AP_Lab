package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class NetworkExpert extends Employees {
    public NetworkExpert(String name, double salary) throws IllegalArgumentException {
        if (salary < 50000.00)
            throw new IllegalArgumentException();
        this.name = name;
        this.salary = salary;
        this.role = "Network Expert";
    }

    @Override
    public double getSalary() {
        return salary;
    }
}