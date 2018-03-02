package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class Cucumber extends Filling {
    Food food;

    public Cucumber(Food food) {
        this.food = food;
        this.description = food.getDescription() + ", adding cucumber";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double cost() {
        return food.cost() + 0.4;
    }
}
