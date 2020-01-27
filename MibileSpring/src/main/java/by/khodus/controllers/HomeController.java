package by.khodus.controllers;


import by.khodus.services.Service;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String homePage(Model model) {
        Logger logger = Logger.getLogger(HomeController.class);
        DOMConfigurator.configure("src/main/resources/log4j.xml");
        logger.warn("try to mobile inicialise");

        Service service = new Service();
        service.findAll();

        logger.warn("mobile inicialised");
        model.addAttribute("mobilesList", service.findAll());
        return "home";
    }
}

