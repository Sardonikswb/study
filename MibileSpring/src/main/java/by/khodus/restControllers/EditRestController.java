package by.khodus.restControllers;


import by.khodus.dao.MobileDao;
import by.khodus.dao.MobileDaoSpring;
import by.khodus.entity.Mobile;
import by.khodus.services.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EditRestController {

    @Autowired
    SpringService springService;

    @Autowired
    MobileDaoSpring mobileDaoSpring;

    @GetMapping(value = "/edit-rest")
    public Optional<Mobile> editPage(@RequestParam String id) {
        int idEdit = Integer.parseInt(id);
        Optional<Mobile> mobile=mobileDaoSpring.findById(idEdit);
        return mobile;
    }

    @PostMapping(value = "/edit-rest")
    public List<Mobile> editHome(@RequestParam String id, @RequestParam String model, @RequestParam String cost) {
        int idEdit = Integer.parseInt(id);
        springService.editMobile(new Mobile(idEdit, model, cost));
        List<Mobile> list = springService.findAll();
        return list;
    }
}
