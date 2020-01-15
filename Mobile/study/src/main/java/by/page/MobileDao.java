package by.page;

import java.util.HashMap;
import java.util.Map;

public class MobileDao {

    private static Map<Integer, Mobile> mobiles = new HashMap<>();


    public static Map<Integer, Mobile> getMobiles() {
        return mobiles;
    }

    public Mobile getMobileId(Integer id) {
        return mobiles.get(id);
    }

    public MobileDao() {
    }

    public static void addMobile(Mobile mobile) {
        mobile.setId(mobiles.size() + 1);
        mobiles.put(mobile.getId(), mobile);
    }

    public static void updateMobile(Mobile mobile) {
        mobiles.get(mobile.getId()).setModel(mobile.getModel());
        mobiles.get(mobile.getId()).setCost(mobile.getCost());
    }

    public static void deleteMobile(Integer id) {
        mobiles.remove(id);
    }
}