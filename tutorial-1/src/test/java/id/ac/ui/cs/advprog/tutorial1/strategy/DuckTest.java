package id.ac.ui.cs.advprog.tutorial1.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;

public class DuckTest {

    private Class<?> duckClass;

    @Before
    public void setUp() throws Exception {
        duckClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.Duck");
    }

    @Test
    public void testDuckIsAbstract() {
        int classModifiers = duckClass.getModifiers();

        assertTrue(Modifier.isAbstract(classModifiers));
    }

    @Test
    public void testDuckHasDisplayMethod() throws Exception {
        Method display = duckClass.getDeclaredMethod("display");
        int methodModifiers = display.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
        assertEquals("void", display.getGenericReturnType().getTypeName());
    }

    @Test
    public void testDuckHasSwimMethod() throws Exception {
        Method swim = duckClass.getDeclaredMethod("swim");
        int methodModifiers = swim.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals("void", swim.getGenericReturnType().getTypeName());
    }

    @Test
    public void testDuckHasFlyBehaviorSetter() throws Exception {
        Method setFlyBehavior = duckClass.getDeclaredMethod("setFlyBehavior",
                FlyBehavior.class);
        Collection<Parameter> parameters = Arrays.asList(setFlyBehavior.getParameters());
        int methodModifiers = setFlyBehavior.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
    }

    @Test
    public void testDuckHasQuackBehaviorSetter() throws Exception {
        Method setQuackBehavior = duckClass.getDeclaredMethod("setQuackBehavior",
                QuackBehavior.class);
        Collection<Parameter> parameters = Arrays.asList(setQuackBehavior.getParameters());
        int methodModifiers = setQuackBehavior.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
    }
}