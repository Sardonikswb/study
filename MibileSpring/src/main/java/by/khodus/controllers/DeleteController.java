package by.khodus.controllers;


import by.khodus.dao.MobileDao;
import by.khodus.services.Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {

    @GetMapping(value = "/delete")
    public String deletePage(Model model) {
        return "delete";
    }

    @PostMapping(value = "/delete")
    public String deleteHome(@RequestParam String id, Model model) {
        int idDelete = Integer.parseInt(id);

        Service service = new Service();

        service.deleteMobile(new MobileDao().findById(idDelete));

        return "redirect:home";
    }
}
