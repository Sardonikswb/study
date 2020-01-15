package by.page;

import by.db.ConnectionToDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
Integer id;
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Integer id = Integer.parseInt(req.getParameter("id"));

        Mobile deleteMobile = MobileDao.getMobileId(id);
        System.out.println(deleteMobile.toString());
        req.setAttribute("deleteMobile", deleteMobile);

        req.getRequestDispatcher("/delete.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

            MobileDao.deleteMobile(id);
        try {
            MobileDao.UpdateMobileDB(ConnectionToDB.getConnection());
        } catch (SQLException e) {
            System.out.println("DELETESERVLET ERRORR!!!!");
        }

        req.setAttribute("mobileList", MobileDao.getMobiles());
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
