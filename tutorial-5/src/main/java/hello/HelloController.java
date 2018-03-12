package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String greeting(@RequestParam(name = "initial", required = false, defaultValue = "Budi")
                                       String initial, Model model) {
        model.addAttribute("initial", initial);
        return "hello";
    }
}
