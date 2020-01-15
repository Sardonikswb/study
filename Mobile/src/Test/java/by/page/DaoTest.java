package by.page;

import by.db.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class DaoTest {
    Session session;

    @Ignore
    @Before
    public void OpenConnectionTest() {
    }

    @Ignore
    @Test
    public void checkConnection() {
        session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        assert (session != null);
        session.close();
    }

    @Ignore
    @Test
    public void checkAddTest() {
        Mobile mobile = new Mobile("asus", "145");
        MobileDao mobileDao = new MobileDao();
        mobileDao.save(mobile);
        List<Mobile> mobiles = mobileDao.findAll();
        assert (mobiles.contains(mobile));
    }

    @Ignore
    @Test
    public void checkDeleteTest() {
        MobileDao mobileDao = new MobileDao();
        Mobile mobile = mobileDao.findById(10);
        mobileDao.delete(mobile);
        List<Mobile> mobiles = mobileDao.findAll();
        assert (mobiles.contains(mobile) == false);
    }

    @Ignore
    @Test
    public void checkEditTest() {
        MobileDao mobileDao = new MobileDao();
        Mobile mobile = new Mobile(13, "dacota", "32");
        mobileDao.update(mobile);
        List<Mobile> mobiles = mobileDao.findAll();
        assert (mobiles.contains(mobile));
    }
}
