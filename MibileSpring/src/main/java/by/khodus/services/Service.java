package by.khodus.services;

import by.khodus.dao.MobileDao;
import by.khodus.dao.MobileDaoSpring;
import by.khodus.entity.Mobile;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements SpringService {

    @Autowired
    MobileDaoSpring mobileDao;

    public Service() {
    }

    public void addMobile(Mobile mobile) {
        Logger logger = Logger.getLogger(MobileDao.class);
        DOMConfigurator.configure("src/main/resources/log4j.xml");
        logger.warn("try to mobile add");
        mobileDao.save(mobile);
        logger.warn("mobile add");

    }

    public void deleteMobile(int id) {
        Logger logger = Logger.getLogger(MobileDao.class);
        DOMConfigurator.configure("src/main/resources/log4j.xml");
        logger.warn("try to mobile delete");

        mobileDao.delete(id);
        logger.warn("mobile delete");
    }

    public void editMobile(Mobile mobile) {
        Logger logger = Logger.getLogger(MobileDao.class);
        DOMConfigurator.configure("src/main/resources/log4j.xml");
        logger.warn("try to mobile edit");
        mobileDao.update(mobile);
        logger.warn("mobile edit");
    }

    public List<Mobile> findAll() {
        return mobileDao.findAll();

    }
}
