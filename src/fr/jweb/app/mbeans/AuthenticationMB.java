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
	

	@ManagedProperty(value="dbManager")
	private DatabaseManagerMB dbManager;
	
	public AuthenticationMB() {
		System.out.println("OMG!! IZIZIZs");
	}
	
	public Boolean loginAction() {
		return (true);
	}
	
	public Boolean logoutAction() {
		return (true);
	}
}
