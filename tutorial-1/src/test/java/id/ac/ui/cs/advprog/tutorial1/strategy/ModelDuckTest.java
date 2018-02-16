package id.ac.ui.cs.advprog.tutorial1.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Before;
import org.junit.Test;

public class ModelDuckTest {

    private Class<?> modelDuckClass;

    @Before
    public void setUp() throws Exception {
        modelDuckClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.ModelDuck");
    }

    @Test
    public void testModelDuckIsADuck() {
        Class<?> parent = modelDuckClass.getSuperclass();

        assertEquals("id.ac.ui.cs.advprog.tutorial1.strategy.Duck", parent.getName());
    }

    @Test
    public void testModelDuckOverrideDisplayMethod() throws Exception {
        Method display = modelDuckClass.getDeclaredMethod("display");
        int methodModifiers = display.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals("void", display.getGenericReturnType().getTypeName());
    }
}