package by.khodus.restControllers;

import by.khodus.entity.Mobile;
import by.khodus.services.SpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListRestController {

    @Autowired
    SpringService springService;

    @GetMapping(value = "/list-rest")
    public List<Mobile> indexPage() {

        List<Mobile> list = springService.findAll();

        return list;
    }

}
