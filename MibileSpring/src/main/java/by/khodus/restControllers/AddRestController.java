package by.khodus.restControllers;


import by.khodus.entity.Mobile;
import by.khodus.services.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddRestController {

    @PostMapping(value = "/add-rest")
    public List<Mobile> addHome(@RequestParam String model, @RequestParam String cost) {

        Service service = new Service();
        service.addMobile(new Mobile(model, cost));
        List<Mobile> list = service.findAll();
        return list;
    }
}

