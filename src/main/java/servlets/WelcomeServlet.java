package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "WelcomeServlet", urlPatterns = "/")
public class WelcomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Object user = servletContext.getAttribute("user");
        if(user==null){
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.html");
//            requestDispatcher.include(req, resp);
            resp.sendRedirect("/login");
        }else{
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/dashboard");
//            requestDispatcher.forward(req, resp);
            resp.sendRedirect("/dashboard");
        }
    }
}
