package fr.jweb.app.mbeans;

import fr.jweb.app.entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import java.io.Serializable;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * SignUp ManagedBean
 * Handle the creation of new Users
 */
@ManagedBean(name = "signupUtility")
@RequestScoped
public class SignUpMB implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    private String username;
    private String password;
    private Boolean newsletter;

    public SignUpMB() {

    }

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }

    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    /**
     * Post a new User in the database with the given informations
     *
     * @return Redirection to the index
     */
    public String newUser() {

        try {
            User tmp = new User();
            tmp.setUsername(this.username);
            tmp.setEmail(this.email);
            tmp.setNewsletter(this.newsletter);
            tmp.setPasswordHash(DigestUtils.sha1Hex(this.password));
            tmp.setAdmin(false);
            dbManager.getUserDao().create(tmp);
            dbManager.getConn().close();
        } catch (SQLException e) {
            System.out.println("SQLException while creating new user: " + e.getMessage());
            e.printStackTrace();
        }
        return ("index?faces-redirect=true");
    }
}
