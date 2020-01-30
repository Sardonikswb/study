package by.khodus.dao;

import by.khodus.entity.Mobile;

import java.util.List;
import java.util.Optional;

public interface MobileDaoSpring {

    void save(Mobile mobile);
    void update(Mobile mobile);
    void delete (int id);
    Optional<Mobile> findById(int id);
    List<Mobile> findAll();
}
