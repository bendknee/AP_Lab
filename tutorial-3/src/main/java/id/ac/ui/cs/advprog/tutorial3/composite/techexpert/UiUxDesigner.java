package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;

public class UiUxDesigner extends Employees {
    public UiUxDesigner(String name, double salary) throws IllegalArgumentException {
        if (salary < 90000.00) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.salary = salary;
        this.role = "UI/UX Designer";
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
