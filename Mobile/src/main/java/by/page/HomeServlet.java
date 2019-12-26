package by.page;

import by.db.ConnectionToDB;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/", "/home"})
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static {
        ConnectionToDB.getConnection();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            MobileDao.getMobilesDB(ConnectionToDB.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            MobileDao.UpdateMobileDB(ConnectionToDB.getConnection());
        } catch (SQLException e) {
        }
        req.setAttribute("mobilesList", MobileDao.getMobiles());
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mobilesList", MobileDao.getMobiles());
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}

