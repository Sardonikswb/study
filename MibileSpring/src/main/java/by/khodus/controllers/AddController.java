package by.khodus.controllers;


import by.khodus.entity.Mobile;
import by.khodus.services.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {


    @GetMapping(value = "/add")
    public String addPage(Model model) {
        return "add";
    }

    @PostMapping(value = "/add")
    public String addHome(@RequestParam String model, @RequestParam String cost) {

        Service service = new Service();
        service.addMobile(new Mobile(model, cost));

        return "redirect:home";
    }
}

