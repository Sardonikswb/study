package by.khodus.restControllers;


import by.khodus.entity.Mobile;
import by.khodus.services.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddRestController {

    @Autowired
    SpringService springService;

    @PostMapping(value = "/add-rest")
    public List<Mobile> addHome(@RequestParam String model, @RequestParam String cost) {

        springService.addMobile(new Mobile(model, cost));
        List<Mobile> list = springService.findAll();
        return list;
    }
}

