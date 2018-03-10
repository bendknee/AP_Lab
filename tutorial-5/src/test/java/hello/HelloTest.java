package hello;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void sayHello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(content().string(containsString("My Hello for, Budi!")));
    }

    @Test
    public void greetingWithUser() throws Exception {
        mockMvc.perform(get("/hello").param("initial", "Greg"))
                .andExpect(content().string(containsString("My Hello for, Greg!")));
    }
}
