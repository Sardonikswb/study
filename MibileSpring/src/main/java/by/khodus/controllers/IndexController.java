package by.khodus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "/index"})
    public String indexPage(Model model) {
        return "index";
    }

    @PostMapping(value = {"/", "/index"})
    public String indexHome(@RequestParam String pass, Model model) {

        return "redirect:home";
    }
}
