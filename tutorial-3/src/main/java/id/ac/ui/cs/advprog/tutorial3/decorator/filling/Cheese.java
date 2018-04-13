package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class Cheese extends Filling {
    Food food;

    public Cheese(Food food) {
        this.food = food;
        this.description = food.getDescription() + ", adding cheese";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double cost() {
        return food.cost() + 2.0;
    }
}
