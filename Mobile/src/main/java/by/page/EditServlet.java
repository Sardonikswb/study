package by.page;

import by.db.ConnectionToDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    static {
        ConnectionToDB.getConnection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String model = req.getParameter("model");
        String cost = req.getParameter("cost");

        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String model = req.getParameter("modelS");
        String cost = req.getParameter("costS");

        MobileDao.editMobileDB(ConnectionToDB.getConnection(), id, model, cost);

        req.setAttribute("mobileList", MobileDao.getMobilesDB(ConnectionToDB.getConnection()));
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
