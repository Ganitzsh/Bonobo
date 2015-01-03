package fr.jweb.app.mbeans;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Ganitzsh
 *
 */

@ManagedBean(name="authentication")
@SessionScoped
public abstract class AuthenticationMB {

	@ManagedProperty(value="#{dbManager}")
	private DatabaseManagerMB dbManager;
	
	@ManagedProperty(value="#{currentUser}")
	private CurrentUserMB	currentUser;
	
	public AuthenticationMB() {
	}

	public DatabaseManagerMB getDbManager() {
		return dbManager;
	}

	public void setDbManager(DatabaseManagerMB dbManager) {
		this.dbManager = dbManager;
	}

	public String LogUser() {
		
		return ("index?faces-redirect=true");
	}

	public Boolean loginAction() {
		return (true);
	}
	
	public Boolean logoutAction() {
		return (true);
	}
}
