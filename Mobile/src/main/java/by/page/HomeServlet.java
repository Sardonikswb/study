package by.page;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        Logger logger = Logger.getLogger(HomeServlet.class);
        DOMConfigurator.configure("src/main/resources/log4j.xml");
        logger.warn("try to mobile inicialise");

        Service service = new Service();
        service.findAll();

        logger.warn("mobile inicialised");

        req.setAttribute("mobilesList", service.findAll());
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = new Service();
        service.findAll();
        req.setAttribute("mobilesList", service.findAll());
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}

