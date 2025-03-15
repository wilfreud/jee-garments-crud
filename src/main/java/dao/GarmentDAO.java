package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Garment;

public class GarmentDAO {
    private Connection con;
    
    public GarmentDAO() {
        con = DatabaseConnection.getConnection();
    }

    public List<Garment> getAllGarments(int userId) {
        List<Garment> list = new ArrayList<>();
        String sql = "SELECT * FROM garments WHERE user_id = ?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Garment garment = new Garment();
                garment.setId(rs.getInt("id"));
                garment.setName(rs.getString("name"));
                garment.setCategory(rs.getString("category"));
                garment.setStatus(rs.getString("status"));
                garment.setLocation(rs.getString("location"));
                garment.setLastActionDate(rs.getDate("last_action_date"));
                garment.setNotes(rs.getString("notes"));
                garment.setUserId(rs.getInt("user_id"));
                list.add(garment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

 public void addGarment(Garment garment) {
    String sql = "INSERT INTO garments (name, category, status, location, last_action_date, notes, user_id) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, garment.getName());
        ps.setString(2, garment.getCategory());
        ps.setString(3, garment.getStatus());
        ps.setString(4, garment.getLocation());
        
        // Gérer lastActionDate si null
        if (garment.getLastActionDate() != null) {
            ps.setDate(5, new java.sql.Date(garment.getLastActionDate().getTime()));
        } else {
            ps.setNull(5, java.sql.Types.DATE); // Définir comme NULL dans la base de données
        }
        
        ps.setString(6, garment.getNotes());
        ps.setInt(7, garment.getUserId());
        
        ps.executeUpdate();
    } catch (SQLException e) {
    	System.err.println("Error in SQL stmt preparation");
        e.printStackTrace();
    }
}

public void updateGarment(Garment garment) {
    String sql = "UPDATE garments SET name=?, category=?, status=?, location=?, "
               + "last_action_date=?, notes=? WHERE id=?";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, garment.getName());
        ps.setString(2, garment.getCategory());
        ps.setString(3, garment.getStatus());
        ps.setString(4, garment.getLocation());
        
        // Gérer lastActionDate si null
        if (garment.getLastActionDate() != null) {
            ps.setDate(5, new java.sql.Date(garment.getLastActionDate().getTime()));
        } else {
            ps.setNull(5, java.sql.Types.DATE); // Définir comme NULL dans la base de données
        }
        
        ps.setString(6, garment.getNotes());
        ps.setInt(7, garment.getId());
        
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public boolean deleteGarment(int id) {
        String sql = "DELETE FROM garments WHERE id=?";
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Garment getGarmentById(int id) {
        String sql = "SELECT * FROM garments WHERE id=?";
        Garment garment = null;
        
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                garment = new Garment();
                garment.setId(rs.getInt("id"));
                garment.setName(rs.getString("name"));
                garment.setCategory(rs.getString("category"));
                garment.setStatus(rs.getString("status"));
                garment.setLocation(rs.getString("location"));
                garment.setLastActionDate(rs.getDate("last_action_date"));
                garment.setNotes(rs.getString("notes"));
                garment.setUserId(rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return garment;
    }
}