/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotebookController;

import NotebookUI.CreateNote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Silviu
 */
public class NotesController {
    
    
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    DBConnection conn = new DBConnection();
    Connection c = conn.getConnection();
    Notes n;
    CreateNote NoteImage;
    public void addNote(Notes n) {
        String query = "Insert into notes(userId, title, text) values(" + n.getIdUser() + "," + n.getTitle() + ",'" + n.getText() + "')";
        try {
            st = c.createStatement();
            st.executeUpdate(query);
        }
        catch (SQLException ex) {
            Logger.getLogger(NotesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void deleteNotes(Notes n) {
        Notes n1 = (Notes) n;
        try {

            String sql = "Delete from notes where id=" + n1.getId();
            ps = c.prepareStatement(sql);
            ps.executeUpdate();
        }

        catch (SQLException ex) {
            Logger.getLogger(NotesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
