package id.ac.ui.cs.advprog.tutorial4.exercise1;

import static org.junit.Assert.assertEquals;


import id.ac.ui.cs.advprog.tutorial4.exercise1.pizza.Pizza;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;


public class FactoryTest {

    private DepokPizzaStore depokFactory;
    private NewYorkPizzaStore yorkFactory;

    @Before
    public void setUp() throws Exception {
        depokFactory = new DepokPizzaStore();
        yorkFactory = new NewYorkPizzaStore();
    }

    @Test
    public void testOrderPizza() {
        Pizza pizza;

        pizza = yorkFactory.orderPizza("cheese");
        assertEquals("New York Style Cheese Pizza", pizza.getName());

        pizza = yorkFactory.orderPizza("veggie");
        assertEquals("New York Style Veggie Pizza", pizza.getName());

        pizza = yorkFactory.orderPizza("clam");
        assertEquals("New York Style Clam Pizza", pizza.getName());

        pizza = depokFactory.orderPizza("cheese");
        assertEquals("Cheese Pizza Ala Depok", pizza.getName());

        pizza = depokFactory.orderPizza("veggie");
        assertEquals("Veggie Pizza Ala Depok", pizza.getName());

        pizza = depokFactory.orderPizza("clam");
        assertEquals("Clam Pizza Ala Depok", pizza.getName());
    }
}
