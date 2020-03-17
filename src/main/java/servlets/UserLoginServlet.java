package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet
public class UserLoginServlet extends HttpServlet {
    private Map<String, String> usersDataMap = new HashMap<>();


    @Override
    public void init() throws ServletException {
        usersDataMap.put("user", "password");
        usersDataMap.put("pracownik", "haslo");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = null;

        Boolean userIsExist = checkUser(req.getParameter("login"), req.getParameter("password"));

        if(userIsExist){
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute("login", req.getParameter("login"));
            path = "/dashboard";
        }else{
            path = "/loginFailed";
        }

        RequestDispatcher adminDispatcher = req.getRequestDispatcher(path);
        adminDispatcher.forward(req, resp);

    }

    private Boolean checkUser(String login, String password) {
        if(usersDataMap.containsKey(login)){
            return usersDataMap.get(login).equals(password);
        }
        return false;
    }
}
