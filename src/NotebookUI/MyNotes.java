package NotebookUI;
import NotebookController.DBConnection;
import NotebookController.Notes;
import NotebookController.User;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.io.BufferedInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;


public class MyNotes extends javax.swing.JFrame {
    DBConnection conn = new DBConnection();
    Connection c = conn.getConnection();
    PreparedStatement pst;
    Statement st;
    ResultSet rs;
    DefaultTableModel dtm;
    String notes[] = {"Id","Title","Description","NoteImage","Date"};
    int xMouse;
    int yMouse;
    public static User u;

   /**
     * Creates new form MyNotes
     */
    
    public MyNotes(User u) {
        
        initComponents();
        this.u = u;
        Date();
        userProfile(u);
        populateTable();
    }

    public void Date(){
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        Date.setText(year +"-" + (month+1) +"-" + day );
    }


    public void userProfile(User u) {
        if(u != null){
        
        UserName2.setText(u.getUsername());
        }
    }
    
    public void populateTable() {
            DBConnection conn = new DBConnection();
            Connection c = conn.getConnection();
        try {
            String sql = ("select id, title, text, noteimage, date from notes where userId=" + u.getId() + " ORDER BY id ASC");
            st = c.createStatement();
            rs = st.executeQuery(sql);
            dtm = new DefaultTableModel(null, notes);

        while(rs.next()){
                Object[] ob = new Object[5];
                ob[0] = rs.getObject(1);
                ob[1] = rs.getObject(2);
                ob[2] = rs.getObject(3);
                ob[3] = rs.getBlob(4);
                ob[4] = rs.getObject(5);
                dtm.addRow(ob);
            }
            table.setModel(dtm);
            }
        catch (Exception e) {
   }
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CloseB = new javax.swing.JLabel();
        MinB = new javax.swing.JLabel();
        UserImg = new javax.swing.JLabel();
        Date = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        FrameDrag = new javax.swing.JLabel();
        UserName2 = new javax.swing.JLabel();
        UserName1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        CloseB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CloseBMouseClicked(evt);
            }
        });
        getContentPane().add(CloseB);
        CloseB.setBounds(770, 10, 20, 20);

        MinB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinBMouseClicked(evt);
            }
        });
        getContentPane().add(MinB);
        MinB.setBounds(730, 10, 30, 20);

        UserImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Male.png"))); // NOI18N
        getContentPane().add(UserImg);
        UserImg.setBounds(40, 180, 250, 280);

        Date.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        Date.setForeground(new java.awt.Color(0, 255, 51));
        getContentPane().add(Date);
        Date.setBounds(0, 10, 150, 30);

        jButton5.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton5.setText("Back");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(550, 530, 110, 50);

        jButton6.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton6.setText("Open");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(330, 530, 100, 50);

        jButton7.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(440, 530, 100, 50);

        jButton8.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jButton8.setText("Exit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(670, 530, 110, 50);

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
        getContentPane().add(FrameDrag);
        FrameDrag.setBounds(0, 0, 720, 30);

        UserName2.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        UserName2.setForeground(new java.awt.Color(0, 153, 0));
        getContentPane().add(UserName2);
        UserName2.setBounds(450, 40, 110, 40);

        UserName1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        UserName1.setForeground(new java.awt.Color(0, 153, 0));
        UserName1.setText("Check your notes");
        getContentPane().add(UserName1);
        UserName1.setBounds(240, 40, 200, 40);

        table.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        table.setForeground(new java.awt.Color(0, 0, 255));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tableMouseMoved(evt);
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(330, 120, 452, 402);

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(330, 90, 140, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/Bg.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 600);

        setSize(new java.awt.Dimension(800, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CloseBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CloseBMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_CloseBMouseClicked

    private void MinBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinBMouseClicked
        // TODO add your handling code here:
        this.setState(MyNotebook.ICONIFIED);
    }//GEN-LAST:event_MinBMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        UserProfile up = new UserProfile(u);
        up.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void FrameDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMouseDragged
        
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
        
    }//GEN-LAST:event_FrameDragMouseDragged

    private void FrameDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrameDragMousePressed
        
        xMouse = evt.getX();
        yMouse = evt.getY();
        
    }//GEN-LAST:event_FrameDragMousePressed

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        
        try {
            Blob img = (Blob) table.getValueAt(table.getSelectedRow(),3);
            BufferedInputStream bis = new BufferedInputStream(img.getBinaryStream());
            Image myImage = ImageIO.read(bis);
            Image imge = myImage.getScaledInstance(UserImg.getWidth(), UserImg.getHeight(), Image.SCALE_SMOOTH);
            UserImg.setIcon(new ImageIcon(imge));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error :" +e.toString());
        }
        
    }//GEN-LAST:event_tableMousePressed


    
    private void tableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseMoved

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

             

    }//GEN-LAST:event_tableMouseClicked
    

    
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
              
        try {
        CreateNote jtRowData = new CreateNote(u);
        
        int index = table.getSelectedRow();
        TableModel model = table.getModel();
        
        String id = model.getValueAt(index, 0).toString();
        String Title = model.getValueAt(index, 1).toString();
        String Description = model.getValueAt(index, 2).toString();
        Blob img = (Blob) table.getValueAt(table.getSelectedRow(),3);
        
        BufferedInputStream bis = new BufferedInputStream(img.getBinaryStream());
        Image myImage = ImageIO.read(bis);
        Image imge = myImage.getScaledInstance(UserImg.getWidth(), UserImg.getHeight(), Image.SCALE_SMOOTH);
        
        jtRowData.setVisible(true);
        jtRowData.pack();
        jtRowData.setLocationRelativeTo(null);
        jtRowData.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jtRowData.nr.setText(id);
        jtRowData.Title.setText(Title);
        jtRowData.Description.setText(Description);
        jtRowData. NoteImage.setIcon(new ImageIcon(imge));
        
        this.dispose();
        } 
        catch (Exception e) {
        }

               
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        
        try {
            DBConnection conn = new DBConnection();
            Connection c = conn.getConnection();
            
            int row = table.getSelectedRow();
            
            String id =""+table.getValueAt(row,0);
            String sql = "DELETE FROM notes WHERE Id = ?";
            
            pst = c.prepareStatement(sql);
            pst.setString( 1, id );
            pst.executeUpdate();
            pst.close();
            DefaultTableModel model = (DefaultTableModel)table.getModel();
            int modelRow = table.convertRowIndexToModel( row );
            model.removeRow( modelRow );
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        LogIn li=new LogIn();
       li.setVisible(true);

    }//GEN-LAST:event_jButton8ActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        
        if(search.getText().equals("")){
            populateTable();
        } 
        else {
        try{
            String sql = "SELECT id, title, text, noteimage, date FROM notes WHERE userId='"+u.getId()+"%' and title like '"+ search.getText() +"%' or text like '" + search.getText() + "%' ";
            pst = c.prepareStatement(sql);
            rs = pst.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            st = c.createStatement();
            rs = st.executeQuery(sql);
            dtm = new DefaultTableModel(null, notes);

        while(rs.next()){
                Object[] ob = new Object[5];
                ob[0] = rs.getObject(1);
                ob[1] = rs.getObject(2);
                ob[2] = rs.getObject(3);
                ob[3] = rs.getBlob(4);
                ob[4] = rs.getObject(5);
                dtm.addRow(ob);
            }
            table.setModel(dtm);
            
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 
        }

    }//GEN-LAST:event_searchKeyReleased

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(MyNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyNotes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyNotes(u).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CloseB;
    public javax.swing.JLabel Date;
    private javax.swing.JLabel FrameDrag;
    private javax.swing.JLabel MinB;
    private javax.swing.JLabel UserImg;
    private javax.swing.JLabel UserName1;
    private javax.swing.JLabel UserName2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField search;
    public javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
