package by.khodus.services;

import by.khodus.entity.Mobile;
import by.khodus.services.Service;
import org.springframework.context.annotation.Bean;

import java.util.List;


public interface SpringService {

    void addMobile(Mobile mobile);
    void deleteMobile(int id);
    void editMobile(Mobile mobile);
    List<Mobile> findAll();

}
