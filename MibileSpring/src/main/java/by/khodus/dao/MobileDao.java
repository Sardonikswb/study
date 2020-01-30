package by.khodus.dao;

import by.khodus.entity.Mobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public class MobileDao implements MobileDaoSpring {

    @Autowired
    private MobileRepository repository;

    public void save(Mobile mobile) {
        repository.saveAndFlush(mobile);
    }

    public void update(Mobile mobile) {
        repository.saveAndFlush(mobile);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Optional<Mobile> findById(int id) {
        return repository.findById(id);
    }

    /*public Mobile findByMobile(Mobile mobile) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Mobile.class, mobile);
    }*/

    public List<Mobile> findAll() {
        List<Mobile> mobiles = (List<Mobile>) repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return mobiles;
    }

    public MobileDao() {
    }
}