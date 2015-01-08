package fr.jweb.app.mbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.jweb.app.entities.User;

/**
 * CurrentUser ManagedBean
 * Handle the user session
 */
@ManagedBean(name = "currentUser")
@SessionScoped
public class CurrentUserMB implements Serializable {

    private static final long serialVersionUID = 1L;
    private User actualUser = new User();
    private Boolean loggedIn = true;

    /**
     * CurrentUser ManagedBean constructor
     * Set the default session
     */
    public CurrentUserMB() {
        actualUser.setUsername("Guest");
        actualUser.setAdmin(false);
        loggedIn = false;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User getActualUser() {
        return actualUser;
    }

    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }
}
