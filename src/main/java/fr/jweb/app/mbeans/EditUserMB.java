package fr.jweb.app.mbeans;

import fr.jweb.app.entities.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.Map;

/**
 * EditUser ManagedBean
 * Handle the edition of a selected user
 */
@ManagedBean(name="edit_user")
@ViewScoped
public class EditUserMB {

    @ManagedProperty(value="#{dbManager}")
    private DatabaseManagerMB dbManager;

    private User    oldUser;
    private String email;
    private String username;
    private Boolean newsletter;
    private Boolean admin;
    
	/**
     * Initialize the bean
     * Get the id of the User to edit in the url
     */
    @PostConstruct
    public void _init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        try {
            oldUser = dbManager.getUserDao().queryForId(Integer.parseInt(requestParams.get("id")));
            dbManager.getConn().close();
            email = oldUser.getEmail();
            username = oldUser.getUsername();
            newsletter = oldUser.getNewsletter();
            admin = oldUser.getAdmin();
        }
        catch (SQLException e) {
            System.out.println("SQLException while getting user: " + e.getMessage());
        }
    }
    
    public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
    /**
     * Update the Products table with product informations
     *
     * @return Redirection to the administration panel
     */
    public String updateUser() {
        try {
            oldUser.setUsername(this.getUsername());
            oldUser.setEmail(this.getUsername());
            oldUser.setNewsletter(this.getNewsletter());
            oldUser.setAdmin(this.admin);
            dbManager.getUserDao().update(oldUser);
            dbManager.getConn().close();
        }
        catch (SQLException e) {
            System.out.println("SQLException while update new user: " + e.getMessage());
            e.printStackTrace();
        }
        return ("admin?faces-redirect=true");
    }

    public User getOldUser() {
        return oldUser;
    }

    public void setOldUser(User oldUser) {
        this.oldUser = oldUser;
    }

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

    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }
}
