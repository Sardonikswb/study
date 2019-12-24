package by.page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
        Integer id = Integer.parseInt(req.getParameter("id"));


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        Mobile mobile = new Mobile(id, req.getParameter("model"), req.getParameter("cost"));
        MobileDao.updateMobile(mobile);

        req.setAttribute("mobileList", MobileDao.getMobiles());
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
