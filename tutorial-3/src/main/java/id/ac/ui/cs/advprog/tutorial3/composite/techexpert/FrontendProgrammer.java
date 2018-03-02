package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class FrontendProgrammer extends Employees {
    public FrontendProgrammer(String name, double salary) throws IllegalArgumentException {
        if (salary < 30000.00)
            throw new IllegalArgumentException();
        this.name = name;
        this.salary = salary;
        this.role = "Front End Programmer";
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
