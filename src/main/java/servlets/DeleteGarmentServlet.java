package servlets;

import java.io.IOException;

import dao.GarmentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/garments/delete")
public class DeleteGarmentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));

        GarmentDAO garmentDAO = new GarmentDAO();
        boolean isDeleted = garmentDAO.deleteGarment(id);

        if (isDeleted) {
            response.setStatus(HttpServletResponse.SC_NO_CONTENT); // HTTP 204 No Content
            response.sendRedirect(request.getContextPath() + "/garments/list");
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // HTTP 404 Not Found
        }
    }
}

