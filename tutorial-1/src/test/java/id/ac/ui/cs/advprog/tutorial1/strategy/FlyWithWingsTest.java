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

public class FlyWithWingsTest {

    private Class<?> flyWithWingsClass;

    @Before
    public void setUp() throws Exception {
        flyWithWingsClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.FlyWithWings");
    }

    @Test
    public void testFlyWithWingsIsAFlyBehavior() {
        Collection<Type> classInterfaces = Arrays.asList(flyWithWingsClass.getInterfaces());

        assertTrue(classInterfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.FlyBehavior"))
        );
    }

    @Test
    public void testFlyWithWingsOverrideFlyMethod() throws Exception {
        Method fly = flyWithWingsClass.getDeclaredMethod("fly");
        int methodModifiers = fly.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals("void", fly.getGenericReturnType().getTypeName());
    }
}