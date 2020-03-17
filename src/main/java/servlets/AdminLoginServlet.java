package servlets;

import bean.User;
import enums.Role;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Boolean isAdmin = checkAdmin(req.getParameter("login"), req.getParameter("password"));
        String path;

        if(isAdmin){
            ServletContext servletContext = getServletContext();
            User user = new User("admin", "admin", Role.ADMIN);
            servletContext.setAttribute("user", user);
            path = "/dashboard";
        }else{
           path = "loginFailed.html";
        }

        RequestDispatcher adminDispatcher = req.getRequestDispatcher(path);
        adminDispatcher.forward(req, resp);
    }

    private Boolean checkAdmin(String login, String password) {
        return "admin".equals(login) && "password".equals(password);
    }
}
