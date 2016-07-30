package NotebookController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//bd, conn, ui,entitati,controller,link


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.*;


public class DBConnection {
 static Connection conn = null;
 Logger l = Logger.getLogger(DBConnection.class.getName());
 public Connection getConnection(){
    try {
   Class.forName("com.mysql.jdbc.Driver");
  } catch (ClassNotFoundException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
   l.severe(e.getMessage());
  }
   try {
    
     if(conn==null){
     
      conn =
          DriverManager.getConnection("jdbc:mysql://localhost:3309/notebookdb?" +
                                     "user=root&password=");
    
      l.info("Created new DB Connection");
     }
     if(conn.isClosed()){

      conn =
             DriverManager.getConnection("jdbc:mysql://localhost:3309/notebookdb?" +
                                        "user=root&password=");
     }
   
  } catch (SQLException ex) {
      // handle any errors
      System.out.println("SQLException: " + ex.getMessage());
      System.out.println("SQLState: " + ex.getSQLState());
      System.out.println("VendorError: " + ex.getErrorCode());
      l.severe("Error while creating Database Connection");
    
  }
  return conn;  
 }

    public PreparedStatement prepareStatement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
