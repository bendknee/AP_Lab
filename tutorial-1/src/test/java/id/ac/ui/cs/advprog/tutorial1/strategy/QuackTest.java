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

public class QuackTest {

    private Class<?> quackClass;

    @Before
    public void setUp() throws Exception {
        quackClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.Quack");
    }

    @Test
    public void testQuackIsAQuackBehavior() {
        Collection<Type> classInterfaces = Arrays.asList(quackClass.getInterfaces());

        assertTrue(classInterfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.QuackBehavior"))
        );
    }

    @Test
    public void testQuackOverrideQuackMethod() throws Exception {
        Method quack = quackClass.getDeclaredMethod("quack");
        int methodModifiers = quack.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals("void", quack.getGenericReturnType().getTypeName());
    }
}