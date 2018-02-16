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


public class SqueakTest {

    private Class<?> squeakClass;

    @Before
    public void setUp() throws Exception {
        squeakClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.Squeak");
    }

    @Test
    public void testSqueakIsAQuackBehavior() {
        Collection<Type> classInterfaces = Arrays.asList(squeakClass.getInterfaces());

        assertTrue(classInterfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.QuackBehavior"))
        );
    }

    @Test
    public void testSqueakOverrideQuackMethod() throws Exception {
        Method quack = squeakClass.getDeclaredMethod("quack");
        int methodModifiers = quack.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals("void", quack.getGenericReturnType().getTypeName());
    }
}