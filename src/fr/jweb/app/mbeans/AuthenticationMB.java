package fr.jweb.app.mbeans;

//import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author Ganitzsh
 *
 */
//@ManagedBean(value="authentication")
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
