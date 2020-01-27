package by.khodus.restControllers;


import by.khodus.dao.MobileDao;
import by.khodus.entity.Mobile;
import by.khodus.services.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeleteRestController {

    @PostMapping(value = "/delete-rest")
    public List<Mobile> deleteHome(@RequestParam String id) {
        int idDelete = Integer.parseInt(id);

        Service service = new Service();
        service.deleteMobile(new MobileDao().findById(idDelete));
        List<Mobile> list = service.findAll();
        return list;
    }
}
