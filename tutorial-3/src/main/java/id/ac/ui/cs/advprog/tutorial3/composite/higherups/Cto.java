package id.ac.ui.cs.advprog.tutorial3.composite.higherups;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class Cto extends Employees {
    public Cto(String name, double salary) throws IllegalArgumentException {
        if (salary < 100000.00)
            throw new IllegalArgumentException();
        this.name = name;
        this.salary = salary;
        this.role = "CTO";
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
