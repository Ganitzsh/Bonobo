package fr.jweb.app.mbeans;

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
	public AuthenticationMB() {
		
	}
	
	public Boolean loginAction() {
		return (true);
	}
	
	public Boolean logoutAction() {
		return (true);
	}
}
