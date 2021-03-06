package fr.jweb.app.mbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.jweb.app.entities.User;

/**
 * UserList ManagedBean
 * Handle the display of all users in the administration panel
 */
@ManagedBean(name = "users")
public class UserListMB {

    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;

    private List<User> userList = new ArrayList<User>();

    public UserListMB() {

    }

    /**
     * Query the database for all users
     */
    @PostConstruct
    public void init() {
        try {
            userList = dbManager.getUserDao().queryForAll();
            dbManager.getConn().close();
        } catch (SQLException e) {
            System.out.println("SQLException while querying users: " + e.getMessage());
        }
    }

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
