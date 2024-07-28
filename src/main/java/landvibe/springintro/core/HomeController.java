package landvibe.springintro.core;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/core")
public class HomeController {

    @GetMapping
    public String home() {
        return "core/home";
    }
}
