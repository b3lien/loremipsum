package pl.akademiakodu.loremipsum2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoremIpsumController {

    @GetMapping
    public String home(){
        return "home";
    }
}
