package by.page;

import by.db.ConnectionToDB;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    static {
        ConnectionToDB.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String model = null;
            String cost = null;

            model = req.getParameter("model");
            cost = req.getParameter("cost");
            MobileDao.addMobileDB(ConnectionToDB.getConnection(), model, cost);

        req.setAttribute("mobileList", MobileDao.getMobilesDB(ConnectionToDB.getConnection()));
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}

