package id.ac.ui.cs.advprog.tutorial3.decorator.filling;

import id.ac.ui.cs.advprog.tutorial3.decorator.Food;

public class TomatoSauce extends Filling {
    Food food;

    public TomatoSauce(Food food) {
        this.food = food;
        this.description = food.getDescription() + ", adding tomato sauce";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double cost() {
        return food.cost() + 0.2;
    }
}
