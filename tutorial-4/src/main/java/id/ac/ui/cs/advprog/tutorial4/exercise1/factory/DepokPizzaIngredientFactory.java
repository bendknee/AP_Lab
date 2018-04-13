package id.ac.ui.cs.advprog.tutorial4.exercise1.factory;

import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.BunCis;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.cheese.Cheese;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.Clams;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.clam.UchihaClam;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.Dough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.dough.TossedDough;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.CounterStrikeSauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.sauce.Sauce;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.BlackOlives;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Eggplant;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Paprika;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Spinach;
import id.ac.ui.cs.advprog.tutorial4.exercise1.factory.veggies.Veggies;

public class DepokPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new TossedDough();
    }

    @Override
    public Sauce createSauce() {
        return new CounterStrikeSauce();
    }

    @Override
    public Cheese createCheese() {
        return new BunCis();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies[] veggies = {new Eggplant(), new Spinach(), new BlackOlives(), new Paprika()};
        return veggies;
    }

    @Override
    public Clams createClam() {
        return new UchihaClam();
    }
}
