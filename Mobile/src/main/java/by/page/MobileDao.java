package by.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MobileDao {

    private static ArrayList<Mobile> mobiles = new ArrayList<Mobile>();

    public MobileDao() {
    }

    public static ArrayList<Mobile> getMobiles() {
        return mobiles;
    }

    public static ArrayList<Mobile> getMobilesDB(Connection connection) throws SQLException {
        String sql = "Select id, model, cost from mobile";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (resultSet.next()) {
            Mobile mobile = new Mobile(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
            mobiles.add(mobile);
        }
        return mobiles;
    }

    public static Mobile getMobileId(Integer id) {
        return mobiles.get(id);
    }

    public static void updateMobile(Mobile mobile) {
        mobiles.get(mobile.getId()).setModel(mobile.getModel());
        mobiles.get(mobile.getId()).setCost(mobile.getCost());
    }

    public static void deleteMobile(Integer id) {
        mobiles.remove(getMobileId(id));
    }

    public static void addMobile(Mobile mobile) {
        if (mobiles.size() != 0) {
            mobile.setId(mobiles.get(mobiles.size() - 1).getId() + 1);
            mobiles.add(mobile);
        } else {
            mobile.setId(1);
            mobiles.add(mobile);
        }
    }

    public static void UpdateMobileDB(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("truncate table mobile");
        preparedStatement.execute();
        preparedStatement = null;
        for (int i = 0; i < mobiles.size(); i++) {
            try {
                preparedStatement = connection.prepareStatement("INSERT INTO mobile values(?,?,?)");
                preparedStatement.setInt(1, MobileDao.getMobileId(i).getId());
                preparedStatement.setString(2, MobileDao.getMobileId(i).getModel());
                preparedStatement.setString(3, MobileDao.getMobileId(i).getCost());
                preparedStatement.execute();
            } catch (SQLException e) {
            }
        }
    }
}