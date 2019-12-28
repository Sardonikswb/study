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
        MobileDao.getMobilesDB(ConnectionToDB.getConnection());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MobileDao.getMobilesDB(ConnectionToDB.getConnection());

        req.setAttribute("mobilesList", MobileDao.getMobilesDB(ConnectionToDB.getConnection()));
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mobilesList", MobileDao.getMobilesDB(ConnectionToDB.getConnection()));
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}

