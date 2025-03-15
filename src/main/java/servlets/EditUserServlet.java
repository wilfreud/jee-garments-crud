package servlets;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/users/edit")
public class EditUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO userDao = new UserDAO();
        User user = userDao.getUserById(id);
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/users/edit.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        
        UserDAO userDao = new UserDAO();
        userDao.updateUser(user);
        
        response.sendRedirect(request.getContextPath() + "/users/list");
    }
}