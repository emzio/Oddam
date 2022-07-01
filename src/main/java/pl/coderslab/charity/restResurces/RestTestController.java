package pl.coderslab.charity.restResurces;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestTestController {

    @GetMapping("rest/test")
    public String restTest(){
        return "rest/test";
    }
}
