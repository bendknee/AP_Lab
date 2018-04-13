package id.ac.ui.cs.advprog.tutorial1.strategy;

public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();

    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
