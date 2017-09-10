package pl.akademiakodu.loremipsum2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.loremipsum2.LoremIpsum;


@Controller
public class LoremIpsumController {

    @Autowired
    private LoremIpsum loremIpsum;

    @GetMapping
    public String home(){
        return "home";
    }

//    @ResponseBody
//    @PostMapping("/generate")
//    public String generate(@ModelAttribute Form form){
//        return form.getNumber()+" "+form.getOption();
//    }


    @GetMapping("/generate")
    public String generate (@RequestParam int number,@RequestParam int option, ModelMap modelMap){
        if (option==1) {
            modelMap.addAttribute("text", loremIpsum.generateParagraphs(number));
        } else if (option == 2){
            modelMap.addAttribute("text",loremIpsum.generateSentences(number));
        } else if (option == 3) {
            modelMap.addAttribute("text",loremIpsum.generateWords(number));
        }
        return "home";
    }

}
