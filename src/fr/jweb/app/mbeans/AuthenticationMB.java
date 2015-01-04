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
 * 
 * @author Ganitzsh
 *
 */

@ManagedBean(name="authentication")
@SessionScoped
public class AuthenticationMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private	String	email;
	private String	password;
	List<User> list = null;

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

	public String logUser() {
		Map<String,Object> map = new HashMap<>();
		map.put("email", this.getEmail());
		try {
			list = dbManager.getUserDao().queryForFieldValues(map);
			for (User user : list) {
				if (user.getPasswordHash().equals(DigestUtils.sha1Hex(this.getPassword()))) {
					currentUser.setLoggedIn(true);
					currentUser.getActualUser().setAdmin(user.getAdmin());
					currentUser.getActualUser().setUsername(user.getUsername());
					currentUser.getActualUser().setNewsletter(user.getNewsletter());
					currentUser.getActualUser().setPasswordHash(DigestUtils.sha1Hex(this.getPassword()));
					currentUser.getActualUser().setEmail(user.getEmail());
					currentUser.getActualUser().setInscriptionDate(user.getInscriptionDate());
					currentUser.getActualUser().setId(user.getId());
				}
			}
		}
		catch (SQLException e) {
			System.out.println("SQLException while getting users: " + e.getMessage());
		}
		return ("index?faces-redirect=true");
	}
	public String logoutUser() {
		((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		return ("index?faces-redirect=true");
	}
}
