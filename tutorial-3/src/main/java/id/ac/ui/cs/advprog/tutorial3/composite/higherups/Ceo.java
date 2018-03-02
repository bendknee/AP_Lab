package id.ac.ui.cs.advprog.tutorial3.composite.higherups;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class Ceo extends Employees {
    public Ceo(String name, double salary) throws IllegalArgumentException {
        if (salary < 200000.00)
            throw new IllegalArgumentException();
        this.name = name;
        this.salary = salary;
        this.role = "CEO";
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
