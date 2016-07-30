/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotebookController;

/**
 *
 * @author Silviu
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String spassword;
    private String email;
    private String contactForm;
    private int date;

    
    User() {
        
    }
    
        public User(int id, String username, String password, String spassword, String email, String contactForm, int date) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.spassword = spassword;
        this.email = email;
        this.contactForm = contactForm;
        this.date = date;


        
    }




    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpassword() {
        return spassword;
    }

    public void setSpassword(String spassword) {
        this.spassword = spassword;
    }

    public String getContactForm() {
        return contactForm;
    }

    public void setContactForm(String contactForm) {
        this.contactForm = contactForm;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
