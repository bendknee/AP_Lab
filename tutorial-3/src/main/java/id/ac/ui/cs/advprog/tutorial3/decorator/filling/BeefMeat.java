package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class BeefMeat extends Filling {
    Food food;

    public BeefMeat(Food food) {
        this.food = food;
        super.description = food.getDescription() + ", adding beef meat";
    }

    @Override
    public String getDescription() {
        return super.description;
    }

    @Override
    public double cost() {
        return food.cost() + 6.0;
    }
}
