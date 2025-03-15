package servlets;

import java.io.IOException;
import java.util.List;

import dao.GarmentDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Garment;
import models.User;

@WebServlet("/garments/list")
public class GarmentListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	        
	        User user = (User) request.getSession().getAttribute("user");
	        List<Garment> garments = new GarmentDAO().getAllGarments(user.getId());
	        
	        request.setAttribute("garments", garments);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/garments/list.jsp");
	        dispatcher.forward(request, response);
	    }

}
