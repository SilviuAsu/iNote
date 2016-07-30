/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotebookUI;
import NotebookController.DBConnection;
import NotebookController.User;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Silviu
 */
public class UserProfile extends javax.swing.JFrame {
    DBConnection conn = new DBConnection();
    Connection c = conn.getConnection();
    public User u;
    int xMouse;
    int yMouse;
    /**
     * Creates new form UserProfile1
     */
    public UserProfile(User u) {
        initComponents();
        this.u = u;
        userProfile(u);
        Date();
        try {
        getUserPic();
        } catch (Exception e) {
        
        }
    }
    public void userProfile(User u) {
        if(u != null){
               UserName.setText(u.getUsername());
        }
    }
    public void Date(){
        
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        Date.setText(year +"-" + (month+1) +"-" + day );
    }  
    private UserProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserImg = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        UserName1 = new javax.swing.JLabel();
        MyNotes = new javax.swing.JButton();
        CreateNote = new javax.swing.JButton();
        DeleteNote = new javax.swing.JButton();
        Contact = new javax.swing.JButton();
        AddPicture = new javax.swing.JButton();
        MinB = new javax.swing.JLabel();
        CloseB = new javax.swing.JLabel();
        FrameDrag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Male.png"))); // NOI18N
        getContentPane().add(UserImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        Date.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        Date.setForeground(new java.awt.Color(0, 255, 51));
        getContentPane().add(Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 30));

        UserName.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        UserName.setForeground(new java.awt.Color(0, 153, 0));
        getContentPane().add(UserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 120, 50));

        UserName1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        UserName1.setForeground(new java.awt.Color(0, 153, 0));
        UserName1.setText("Add your note");
        getContentPane().add(UserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 170, 50));

        MyNotes.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        MyNotes.setText("My Notes");
        MyNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MyNotesActionPerformed(evt);
            }
        });
        getContentPane().add(MyNotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 140, 50));

        CreateNote.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        CreateNote.setText("Create Note");
        CreateNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNoteActionPerformed(evt);
            }
        });
        getContentPane().add(CreateNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 140, 50));

        DeleteNote.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        DeleteNote.setText("Exit");
        DeleteNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteNoteActionPerformed(evt);
            }
        });
        getContentPane().add(DeleteNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 420, 140, 50));

        Contact.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        Contact.setText("Contact");
        Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactActionPerformed(evt);
            }
        });
        getContentPane().add(Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 140, 50));

        AddPicture.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        AddPicture.setText("Add Picture");
        AddPicture.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPictureActionPerformed(evt);
            }
        });
        getContentPane().add(AddPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 470, 140, 50));

        MinB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinBMouseClicked(evt);
            }
        });
        getContentPane().add(MinB, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 30, 20));

        CloseB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseBMouseClicked(evt);
            }
        });
        getContentPane().add(CloseB, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, 20, 20));

        FrameDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                FrameDragMouseDragged(evt);
            }
        });
        FrameDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                FrameDragMousePressed(evt);
            }
        });
        getContentPane().add(FrameDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Bg.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MyNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MyNotesActionPerformed
        this.dispose();
        MyNotes mn = new MyNotes(u);
        mn.setVisible(true);

    }//GEN-LAST:event_MyNotesActionPerformed

    private void CreateNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNoteActionPerformed
        this.dispose();
        CreateNote cn = new CreateNote(u);
        cn.setVisible(true);

    }//GEN-LAST:event_CreateNoteActionPerformed

    private void DeleteNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteNoteActionPerformed
       this.dispose();
        LogIn li=new LogIn();
       li.setVisible(true);

    }//GEN-LAST:event_DeleteNoteActionPerformed

    private void ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactActionPerformed
        this.dispose();
        Contact c = new Contact(u);
        c.setVisible(true);
 
    }//GEN-LAST:event_ContactActionPerformed

    private void AddPictureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPictureActionPerformed
        
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fc.setMultiSelectionEnabled(false);
        fc.showOpenDialog(this);
        
        File f=fc.getSelectedFile();
        ImageIcon path = new ImageIcon(f.getAbsolutePath());
        
        Rectangle rect =UserImg.getBounds();
        Image scaledImage = path.getImage().getScaledInstance(rect.width, rect.height, Image.SCALE_DEFAULT);
        
        path = new ImageIcon(scaledImage);
        UserImg.setIcon(path);
        try {
            FileInputStream fin = new FileInputStream(f);
            int len=(int) f.length();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3309/notebookdb?" +
                                     "user=root&password=");
            PreparedStatement ps = con.prepareStatement("update userprofile set UserImage=? where id=" + u.getId());
            ps.setBinaryStream(1, fin, len);
            int status = ps.executeUpdate();
            if(status>0) {
                JOptionPane.showMessageDialog(null, "Succesufully inserted!");
              } else{
                 JOptionPane.showMessageDialog(null, "Not inserted!");
            }
        } catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this,e);
        }
    }//GEN-LAST:event_AddPictureActionPerformed

        public User getUserPic(){
        ResultSet rs;
            try {
            String query = "Select UserImage from userprofile where ID=" + u.getId();
            Statement s = c.createStatement();
            rs = s.executeQuery(query);
            if (rs.next()) {
                byte[] img = rs.getBytes("UserImage");
                ImageIcon image = new ImageIcon (img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(UserImg.getWidth(),UserImg.getHeight(),Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                UserImg.setIcon(newImage);
            }
             else {
                JOptionPane.showMessageDialog(null, "No data");
            }

        }
        catch (SQLException ex) {
            Logger.getLogger(UserProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }
        

    
    private void MinBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinBMouseClicked
        // TODO add your handling code here:
        this.setState(MyNotebook.ICONIFIED);
    }//GEN-LAST:event_MinBMouseClicked

    private void CloseBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseBMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseBMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void FrameDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMouseDragged
       int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_FrameDragMouseDragged

    private void FrameDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMousePressed
       xMouse = evt.getX();
       yMouse = evt.getY();
    }//GEN-LAST:event_FrameDragMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPicture;
    private javax.swing.JLabel CloseB;
    private javax.swing.JButton Contact;
    private javax.swing.JButton CreateNote;
    private javax.swing.JLabel Date;
    private javax.swing.JButton DeleteNote;
    private javax.swing.JLabel FrameDrag;
    private javax.swing.JLabel MinB;
    private javax.swing.JButton MyNotes;
    private javax.swing.JLabel UserImg;
    public javax.swing.JLabel UserName;
    private javax.swing.JLabel UserName1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
