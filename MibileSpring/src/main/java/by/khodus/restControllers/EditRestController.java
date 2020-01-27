package by.khodus.restControllers;


import by.khodus.dao.MobileDao;
import by.khodus.entity.Mobile;
import by.khodus.services.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EditRestController {

    @GetMapping(value = "/edit-rest")
    public Mobile editPage(@RequestParam String id) {
        int idEdit = Integer.parseInt(id);
        Mobile mobile = new MobileDao().findById(idEdit);
        return mobile;
    }

    @PostMapping(value = "/edit-rest")
    public List<Mobile> editHome(@RequestParam String id, @RequestParam String model, @RequestParam String cost) {
        int idEdit = Integer.parseInt(id);
        Service service = new Service();
        service.editMobile(new Mobile(idEdit, model, cost));
        List<Mobile> list = service.findAll();
        return list;
    }
}
