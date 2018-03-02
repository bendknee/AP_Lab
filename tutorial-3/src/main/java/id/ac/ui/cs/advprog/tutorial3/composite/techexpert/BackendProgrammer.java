package id.ac.ui.cs.advprog.tutorial3.composite.techexpert;

import id.ac.ui.cs.advprog.tutorial3.composite.Employees;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

public class BackendProgrammer extends Employees {
    public BackendProgrammer(String name, double salary) throws IllegalArgumentException {
        if (salary < 20000.00)
            throw new IllegalArgumentException();
    	this.name = name;
    	this.salary = salary;
    	this.role = "Back End Programmer";
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
