package beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 4L;

	private long		id;
	private String		username;
	private String		email;
	private String		passwordHash; // SHA1 hash
	private	Timestamp	inscriptionDate;
	private Boolean		newsletter;
	private Boolean		admin;
	
	public UserBean()
	{
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Timestamp getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Timestamp inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public Boolean getNewsletter() {
		return newsletter;
	}

	public void setNewsletter(Boolean newsletter) {
		this.newsletter = newsletter;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
