package id.ac.ui.cs.advprog.tutorial1.strategy;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Before;
import org.junit.Test;

public class QuackBehaviorTest {

    private Class<?> quackBehaviorClass;

    @Before
    public void setUp() throws Exception {
        quackBehaviorClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.QuackBehavior");
    }

    @Test
    public void testQuackBehaviorIsAPublicInterface() {
        int classModifiers = quackBehaviorClass.getModifiers();

        assertTrue(Modifier.isInterface(classModifiers));
        assertTrue(Modifier.isPublic(classModifiers));
    }

    @Test
    public void testQuackBehaviorHasQuackAbstractMethod() throws Exception {
        Method quack = quackBehaviorClass.getDeclaredMethod("quack");
        int methodModifiers = quack.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
    }
}