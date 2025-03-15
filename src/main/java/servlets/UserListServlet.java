package servlets;

import java.io.IOException;
import java.util.List;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

@WebServlet("/users/list")
public class UserListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        UserDAO userDao = new UserDAO();
        List<User> users = userDao.getAllUsers();
        
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/users/list.jsp").forward(request, response);
    }
}