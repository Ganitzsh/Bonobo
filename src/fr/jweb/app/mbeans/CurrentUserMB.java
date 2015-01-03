package fr.jweb.app.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.jweb.app.entities.User;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean(name="currentUser")
@SessionScoped
public class CurrentUserMB {

	private User 		actualUser = new User();
	private Boolean		loggedIn = true;

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public CurrentUserMB() {
		
	}

	public User getActualUser() {
		return actualUser;
	}

	public void setActualUser(User actualUser) {
		this.actualUser = actualUser;
	}
}
