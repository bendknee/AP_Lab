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


public class FlyRocketPoweredTest {

    private Class<?> flyRocketPoweredClass;

    @Before
    public void setUp() throws Exception {
        flyRocketPoweredClass =
                Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.FlyRocketPowered");
    }

    @Test
    public void testFlyRocketPoweredIsAFlyBehavior() {
        Collection<Type> classInterfaces = Arrays.asList(flyRocketPoweredClass.getInterfaces());

        assertTrue(classInterfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.FlyBehavior"))
        );
    }

    @Test
    public void testFlyWithWingsOverrideFlyMethod() throws Exception {
        Method fly = flyRocketPoweredClass.getDeclaredMethod("fly");
        int methodModifiers = fly.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals("void", fly.getGenericReturnType().getTypeName());
    }
}