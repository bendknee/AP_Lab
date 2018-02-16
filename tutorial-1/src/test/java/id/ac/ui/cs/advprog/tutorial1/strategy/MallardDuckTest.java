package id.ac.ui.cs.advprog.tutorial1.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class MallardDuckTest {

    private Class<?> mallardDuckClass;

    @Before
    public void setUp() throws Exception {
        mallardDuckClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.MallardDuck");
    }

    @Test
    public void testMallardDuckIsADuck() {
        Class<?> parent = mallardDuckClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.Duck", parent.getName());
    }

    @Test
    public void testMallardDuckOverrideDisplayMethod() throws Exception {
        Method display = mallardDuckClass.getDeclaredMethod("display");
        int methodModifiers = display.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals("void", display.getGenericReturnType().getTypeName());
    }
}