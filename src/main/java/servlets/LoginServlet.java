package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import service.LoginService;
import service.impl.LoginServiceImpl;


@WebServlet(name = "LoginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {

    private final LoginService loginService = new LoginServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Login login = new Login();
        login.setNombre(username);
        login.setContranesa(password);

        if (loginService.enterLogin(login)) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    
    }
        
    
   
}

