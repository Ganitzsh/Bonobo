package fr.jweb.app.mbeans;

import fr.jweb.app.entities.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.sql.SQLException;
import org.apache.commons.codec.digest.DigestUtils;

@ManagedBean(name="signupUtility")
@RequestScoped
public class SignUpMB {

	private String	email;
	private String	username;
	private String	password;
	private Boolean	newsletter;

	public DatabaseManagerMB getDbManager() {
		return dbManager;
	}

	public void setDbManager(DatabaseManagerMB dbManager) {
		this.dbManager = dbManager;
	}

	@ManagedProperty(value="#{dbManager}")
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

	public String newUser() {
		User NewUser = new User();
		NewUser.setUsername(this.getUsername());
		NewUser.setEmail(this.getEmail());
		NewUser.setNewsletter(this.getNewsletter());
		NewUser.setPasswordHash(new String(DigestUtils.sha1(this.getPassword())));

		try {
			dbManager.getUserDao().create(NewUser);
		}
		catch (SQLException e) {
			System.out.println("SQLException while creating new user: " + e.getMessage());
		}
		return ("index?faces-redirect=true");
	}

	public SignUpMB()
	{
		
	}
}
