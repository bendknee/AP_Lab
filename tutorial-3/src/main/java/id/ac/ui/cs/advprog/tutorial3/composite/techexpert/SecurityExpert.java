package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class SecurityExpert extends Employees {
    public SecurityExpert(String name, double salary) throws IllegalArgumentException {
        if (salary < 70000.00) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.salary = salary;
        this.role = "Security Expert";
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
