/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotebookController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silviu
 */
public class UserController {
    
    DBConnection connection = new DBConnection();
    

    
    
    //o metoda de stocare a tuturor utilizatorilor din baza de date
     public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();
       Connection con = connection.getConnection();
       String query = "SELECT * FROM userprofile";
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            while(rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setSpassword(rs.getString("spassword"));
                u.setSpassword(rs.getString("Email"));
                users.add(u);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    

     
}
