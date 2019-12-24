package by.page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MobileDao {

    private static Map<Integer, Mobile> mobiles = new HashMap<>();


    public static Mobile getMobileId(Integer id) {
        return mobiles.get(id);
    }

    public MobileDao() {
    }

    public static void updateMobile(Mobile mobile) {
        mobiles.get(mobile.getId()).setModel(mobile.getModel());
        mobiles.get(mobile.getId()).setCost(mobile.getCost());
    }

    public static void deleteMobile(Integer id) {

        mobiles.remove(id);
    }

    public static void addMobile(Mobile mobile) {
        mobile.setId(mobiles.size() + 1);
        mobiles.put(mobile.getId(), mobile);
    }

    public static void UpdateMobileDB(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = null;
        preparedStatement= connection.prepareStatement("truncate table mobile");
        preparedStatement.execute();
        preparedStatement = null;
        for (int i = 1; i <= mobiles.size(); i++) {
            try {
                preparedStatement= connection.prepareStatement("INSERT INTO mobile values(?,?,?)");
                preparedStatement.setInt(1, MobileDao.getMobiles().get(i).getId());
                preparedStatement.setString(2,MobileDao.getMobiles().get(i).getModel());
                preparedStatement.setString(3,MobileDao.getMobiles().get(i).getCost());
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("MOBILEDAO ERROR!!!!!!!!!!!!!!11");
            }

        }
    }

    public static Map<Integer, Mobile> getMobiles() {
        return mobiles;
    }

    public static Map<Integer, Mobile> getMobilesDB(Connection connection) throws SQLException {
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
            mobiles.put(mobile.getId(), mobile);
        }
        return mobiles;
    }

}