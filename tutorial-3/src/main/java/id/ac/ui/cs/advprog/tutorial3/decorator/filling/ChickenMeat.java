package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class ChickenMeat extends Filling {
    Food food;

    public ChickenMeat(Food food) {
        this.food = food;
        this.description = food.getDescription() + ", adding chicken meat";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double cost() {
        return food.cost() + 4.5;
    }
}
