package by.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/","/home"})
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    public void init() throws ServletException {
        super.init();

        MobileDao.addMobile(new Mobile(1,"Nokia", "20"));
        MobileDao.addMobile(new Mobile(2,"Samsung", "200"));
        MobileDao.addMobile(new Mobile(3,"Aplle", "1800"));
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String action = (String) req.getAttribute("name");

        if ("add".equals(action)){
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
        }else {
            req.setAttribute("mobilesList", MobileDao.getMobiles());
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        }
        // request.getRequestDispatcher("/jsp/mainPage.jsp").forward(request, response);
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("Enter doGet on mainPage");
        String action = req.getParameter("name");
        //System.out.println("action =="+action);
        if ("add".equals(action)){
            req.getRequestDispatcher("/add.jsp").forward(req, resp);
        }else {
            req.setAttribute("mobilesList", MobileDao.getMobiles());
            req.getRequestDispatcher("/home.jsp").forward(req, resp);
        }
        // request.getRequestDispatcher("/jsp/mainPage.jsp").forward(request, response);
    }

}

