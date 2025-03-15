package servlets;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String VUE_LOGIN = "/WEB-INF/auth/login.jsp";
    private static final String VUE_LISTE = "/garments/list";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        UserDAO userDao = new UserDAO();
        User user = userDao.validateUser(username, password);
        
        if(user != null) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + VUE_LISTE);
        } else {
            request.setAttribute("error", "Identifiants invalides");
            getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
        }
    }
}