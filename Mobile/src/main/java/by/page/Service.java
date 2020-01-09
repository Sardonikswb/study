package by.page;

import java.util.List;

public class Service {

    private MobileDao mobileDao = new MobileDao();

    public Service() {
    }

    public void addMobile(Mobile mobile) {
        mobileDao.save(mobile);
    }

    public void deleteMobile(Mobile mobile) {
        mobileDao.delete(mobile);
    }

    public void editMobile(Mobile mobile) {
        mobileDao.update(mobile);
    }

    public List<Mobile> findAll() {
        return mobileDao.findAll();
    }
}
