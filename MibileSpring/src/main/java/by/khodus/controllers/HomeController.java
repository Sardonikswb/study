package by.khodus.controllers;


import by.khodus.services.SpringService;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    SpringService springService;

    @RequestMapping(value = "/home")
    public String homePage(Model model) {
        Logger logger = Logger.getLogger(HomeController.class);
        DOMConfigurator.configure("src/main/resources/log4j.xml");
        logger.warn("try to mobile inicialise");

        model.addAttribute("mobilesList", springService.findAll());
        logger.warn("mobile inicialised");
        return "home";
    }
}

