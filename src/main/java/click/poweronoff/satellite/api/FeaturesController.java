package click.poweronoff.satellite.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeaturesController {
    @RequestMapping("/features")
    public @ResponseBody
    String features() {
        return "a dummy message";
    }

}
