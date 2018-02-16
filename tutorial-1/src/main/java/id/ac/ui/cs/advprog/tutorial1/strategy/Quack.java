package id.ac.ui.cs.advprog.tutorial1.strategy;

public class Quack implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
