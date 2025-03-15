package servlets;

import java.io.IOException;

import dao.GarmentDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.Garment;

@WebServlet("/garments/edit")
public class EditGarmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Garment garment = new GarmentDAO().getGarmentById(id);
        
        request.setAttribute("garment", garment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/garments/edit.jsp");
        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
            
            // Récupérer les données du formulaire
            Garment garment = new Garment();
            garment.setId(Integer.parseInt(request.getParameter("id")));
            garment.setName(request.getParameter("name"));
            garment.setCategory(request.getParameter("category"));
            garment.setStatus(request.getParameter("status"));
            garment.setLocation(request.getParameter("location"));
            
            // Mettre à jour l'habit dans la base de données
            GarmentDAO garmentDao = new GarmentDAO();
            garmentDao.updateGarment(garment);
            
            // Rediriger vers la liste des habits
            response.sendRedirect(request.getContextPath() + "/garments/list");
    }
}
