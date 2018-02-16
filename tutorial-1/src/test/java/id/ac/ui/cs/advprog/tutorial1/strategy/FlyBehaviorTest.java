package id.ac.ui.cs.advprog.tutorial1.strategy;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.Before;
import org.junit.Test;

public class FlyBehaviorTest {

    private Class<?> flyBehaviorClass;

    @Before
    public void setUp() throws Exception {
        flyBehaviorClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.FlyBehavior");
    }

    @Test
    public void testFlyBehaviorIsAPublicInterface() {
        int classModifiers = flyBehaviorClass.getModifiers();

        assertTrue(Modifier.isPublic(classModifiers));
        assertTrue(Modifier.isInterface(classModifiers));
    }

    @Test
    public void testFlyBehaviorHasFlyAbstractMethod() throws Exception {
        Method fly = flyBehaviorClass.getDeclaredMethod("fly");
        int methodModifiers = fly.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertTrue(Modifier.isAbstract(methodModifiers));
    }
}
