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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Mobile editMobile = MobileDao.getMobileId(id);
        System.out.println(editMobile.toString());
        req.setAttribute("editMobile", editMobile);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        Mobile mobile = new Mobile(id, req.getParameter("model"), req.getParameter("cost"));
        MobileDao.updateMobile(mobile);

        try {
            MobileDao.UpdateMobileDB(ConnectionToDB.getConnection());
        } catch (SQLException e) {
            System.out.println("EDITSERVLET ERRORR!!!!");
        }

        req.setAttribute("mobileList", MobileDao.getMobiles());
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
