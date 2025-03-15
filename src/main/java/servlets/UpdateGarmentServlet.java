package servlets;

import java.io.IOException;

import dao.GarmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.Garment;

@WebServlet("/garments/update")
public class UpdateGarmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Garment garment = new GarmentDAO().getGarmentById(id);
        
        garment.setName(request.getParameter("name"));
        garment.setCategory(request.getParameter("category"));
        garment.setStatus(request.getParameter("status"));
        garment.setLocation(request.getParameter("location"));
        
        new GarmentDAO().updateGarment(garment);
        response.sendRedirect("list");
    }
}
