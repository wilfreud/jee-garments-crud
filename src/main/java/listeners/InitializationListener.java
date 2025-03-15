package listeners;

import dao.UserDAO;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import models.User;
import org.mindrot.jbcrypt.BCrypt;

@WebListener
public class InitializationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Démarrage de l'application : vérification de l'utilisateur admin...");
        
        UserDAO userDao = new UserDAO();
        String adminUsername = "admin";
        
        // Vérifier si l'utilisateur admin existe déjà
        if (userDao.getUserByUsername(adminUsername) == null) {
            System.out.println("Création de l'utilisateur admin...");
            
            User admin = new User();
            admin.setUsername(adminUsername);
            admin.setPassword("admin"); // Hash du mot de passe
            
            userDao.createUser(admin);
            System.out.println("Utilisateur admin créé avec succès !");
        } else {
            System.out.println("L'utilisateur admin existe déjà.");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Arrêt de l'application...");
    }
}