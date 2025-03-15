package servlets;

import jakarta.servlet.http.HttpServlet;
import models.Garment;
import models.User;

import java.io.IOException;
import java.util.List;

import dao.GarmentDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/garments/add")
public class AddGarmentServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	        
	        User user = (User) request.getSession().getAttribute("user");
	        
	        Garment garment = new Garment();
	        garment.setName(request.getParameter("name"));
	        garment.setCategory(request.getParameter("category"));
	        garment.setStatus(request.getParameter("status"));
	        garment.setLocation(request.getParameter("location"));
	        garment.setUserId(user.getId());
	        
	        new GarmentDAO().addGarment(garment);
	        response.sendRedirect("list");
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	        
	        // Afficher le formulaire d'ajout
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/garments/add.jsp");
	        dispatcher.forward(request, response);
	    }
	
}
