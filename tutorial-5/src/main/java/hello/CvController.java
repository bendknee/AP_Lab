package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CvController {

    @GetMapping("/cv")
    public String greeting(@RequestParam(name = "name", required = true)
                                       String name, Model model) {
        if (name == null | name == "" | name == " ") {
            model.addAttribute("header", "This is my CV");
        } else {
            model.addAttribute("header", name + ", I hope you interested to hire me");
        }
        return "cv";
    }

}
