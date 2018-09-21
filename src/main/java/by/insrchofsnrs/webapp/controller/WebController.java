package by.insrchofsnrs.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value="/")
    public String homepage(Model model){

        return "index";
    }
}
