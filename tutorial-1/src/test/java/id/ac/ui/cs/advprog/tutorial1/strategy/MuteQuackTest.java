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

public class MuteQuackTest {

    private Class<?> muteQuackClass;

    @Before
    public void setUp() throws Exception {
        muteQuackClass = Class.forName("id.ac.ui.cs.advprog.tutorial1.strategy.MuteQuack");
    }

    @Test
    public void testMuteQuackIsAQuackBehavior() {
        Collection<Type> classInterfaces = Arrays.asList(muteQuackClass.getInterfaces());

        assertTrue(classInterfaces.stream()
                .anyMatch(type -> type.getTypeName()
                        .equals("id.ac.ui.cs.advprog.tutorial1.strategy.QuackBehavior"))
        );
    }

    @Test
    public void testQuackOverrideQuackMethod() throws Exception {
        Method quack = muteQuackClass.getDeclaredMethod("quack");
        int methodModifiers = quack.getModifiers();

        assertTrue(Modifier.isPublic(methodModifiers));
        assertEquals("void", quack.getGenericReturnType().getTypeName());
    }
}