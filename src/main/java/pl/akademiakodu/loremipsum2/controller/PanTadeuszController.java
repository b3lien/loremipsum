package pl.akademiakodu.loremipsum2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.akademiakodu.loremipsum2.PanTadeusz;


@Controller
public class PanTadeuszController {

    @Autowired
    private PanTadeusz panTadeusz;

    @GetMapping("/pl")
    public String home() {
        return "homepl";
    }

    @GetMapping("/pl/generate")
    public String generate(@RequestParam int number, @RequestParam int option, ModelMap modelMap) {
        if (option == 4) {
            modelMap.addAttribute("text", panTadeusz.generateParagraphs(number));
        } else if (option == 5) {
            modelMap.addAttribute("text", panTadeusz.generateSentences(number));
        } else if (option == 6) {
            modelMap.addAttribute("text", panTadeusz.generateWords(number));
        }
        return "homepl";
    }
}
