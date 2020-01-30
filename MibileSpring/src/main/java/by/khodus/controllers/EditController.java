package by.khodus.controllers;


import by.khodus.entity.Mobile;
import by.khodus.services.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditController {

    @Autowired
    SpringService springService;


    @GetMapping(value = "/edit")
    public String editPage() {
        return "edit";
    }

    @PostMapping(value = "/edit")
    public String editHome(@RequestParam String id, @RequestParam String modelS, @RequestParam String costS) {
        int idEdit = Integer.parseInt(id);

        springService.editMobile(new Mobile(idEdit, modelS, costS));

        return "redirect:home";
    }
}
