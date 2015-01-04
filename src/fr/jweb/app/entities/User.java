package fr.jweb.app.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * User model class
 * Contains a username, an email, a password (crypted with sha1)
 */
@DatabaseTable(tableName = "user")
public class User {

    @DatabaseField(id = true)
    private long id;
    @DatabaseField
    private String username;
    @DatabaseField
    private String email;
    @DatabaseField
    private String passwordHash;
    /**
     * Defines if the user subscribed to the newsletter
     */
    @DatabaseField
    private Boolean newsletter;
    /**
     * Defines if the user is an administrator
     */
    @DatabaseField
    private Boolean admin;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    /**
     * User model constructor
     */
    public User() {
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


    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }
}
