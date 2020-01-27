package by.khodus.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Filter1 implements Filter {
    String w;

    public Filter1() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        w = "4444";
    }

    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String password = (String) request.getParameter("pass");

        if ((password != null) && (password.equals(w))) {
            chain.doFilter(request, response);
        } else {
            resp.sendRedirect(req.getContextPath() + "");
        }
    }
}
