package fr.jweb.app.mbeans;

import fr.jweb.app.entities.User;

import org.apache.commons.codec.digest.DigestUtils;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 * Authentication managedBean
 * Handle the users authentication after checking the credentials they gave
 */
@ManagedBean(name="authentication")
@SessionScoped
public class AuthenticationMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private	String	email;
	private String	password;
	private Boolean	failed = false;
	List<User> list = null;

	public Boolean getFailed() {
		return failed;
	}

	public void setFailed(Boolean failed) {
		this.failed = failed;
	}

	@ManagedProperty(value="#{dbManager}")
	private DatabaseManagerMB dbManager;
	
	@ManagedProperty(value="#{currentUser}")
	private CurrentUserMB	currentUser;
	
	public AuthenticationMB() {
	}

	public DatabaseManagerMB getDbManager() {
		return dbManager;
	}
	public CurrentUserMB getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CurrentUserMB currentUser) {
		this.currentUser = currentUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDbManager(DatabaseManagerMB dbManager) {
		this.dbManager = dbManager;
	}

	/**
	 * Method handling the user authentication
	 * Verify the credential and then set the CurrentUser session variables
	 * @return Redirection to the index page
	 */
	public String logUser() {
		Map<String,Object> map = new HashMap<>();
		map.put("email", this.getEmail());
		try {
			list = dbManager.getUserDao().queryForFieldValues(map);
			dbManager.getConn().close();
			for (User user : list) {
				if (user.getPasswordHash().equals(DigestUtils.sha1Hex(this.getPassword()))) {
					currentUser.setLoggedIn(true);
					currentUser.getActualUser().setAdmin(user.getAdmin());
					currentUser.getActualUser().setUsername(user.getUsername());
					currentUser.getActualUser().setNewsletter(user.getNewsletter());
					currentUser.getActualUser().setPasswordHash(DigestUtils.sha1Hex(this.getPassword()));
					currentUser.getActualUser().setEmail(user.getEmail());
					currentUser.getActualUser().setId(user.getId());
					failed = false;
				}
			}
			if (!currentUser.getLoggedIn())
				failed = true;
		}
		catch (SQLException e) {
			System.out.println("SQLException while getting users: " + e.getMessage());
		}
		return ("index?faces-redirect=true");
	}

	/**
	 * Disconnect the user
	 * @return Redirection to the index page
	 */
	public String logoutUser() {
		((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return ("index?faces-redirect=true");
	}
}
