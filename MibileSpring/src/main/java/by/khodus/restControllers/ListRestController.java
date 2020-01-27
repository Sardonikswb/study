package by.khodus.restControllers;

import by.khodus.entity.Mobile;
import by.khodus.services.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListRestController {

    @GetMapping(value = "/list-rest")
    public List<Mobile> indexPage() {
       
        Service service = new Service();
        List<Mobile> list = service.findAll();

        return list;
    }

}
