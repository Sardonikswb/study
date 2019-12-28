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

    public static ArrayList<Mobile> getMobilesDB(Connection connection) {
        mobiles.clear();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("Select id, model, cost from mobile");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                Mobile mobile = new Mobile(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                mobiles.add(mobile);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mobiles;
    }

     public static int getIdBD(Connection connection, String model, String cost) {
        int id = 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement("select id from mobile where model='" + model + "' and cost='" + cost + "'");
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            id = resultSet.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public static void addMobileDB(Connection connection, String model, String cost) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO mobile (model,cost) VALUES (?,?)");
            preparedStatement.setString(1, model);
            preparedStatement.setString(2, cost);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMobileDB(Connection connection, int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM mobile WHERE id =" + id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public static void editMobileDB(Connection connection, int id, String model, String cost){
        PreparedStatement preparedStatement = null;
       try {
           preparedStatement = connection.prepareStatement("UPDATE mobile SET model='"+model+"', cost='"+cost+"' WHERE id="+id);
       preparedStatement.execute();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}