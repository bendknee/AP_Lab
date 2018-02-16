package id.ac.ui.cs.advprog.tutorial1.strategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;

public class FlyNoWayTest {

    private Class<?> flyNoWayClass;

    @Before
    public void setUp() throws Exception {
        flyNoWayClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.FlyNoWay");
    }

    @Test
    public void testFlyNoWayIsAFlyBehavior() {
        Collection<Type> classInterfaces = Arrays.asList(flyNoWayClass.getInterfaces());

        assertTrue(classInterfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.FlyBehavior"))
        );
    }

    @Test
    public void testFlyNoWayOverrideFlyMethod() throws Exception {
        Method fly = flyNoWayClass.getDeclaredMethod("fly");
        int methodModifiers = fly.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals("void", fly.getGenericReturnType().getTypeName());
    }
}