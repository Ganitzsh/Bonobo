package fr.jweb.app.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.jweb.app.daos.UserDAO;
import fr.jweb.app.entities.User;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean(name="users")
public class UserListMB {
	
	private UserDAO	userDataSource;
	
	public UserDAO getUserDataSource() {
		return userDataSource;
	}

	public void setUserDataSource(UserDAO userDataSource) {
		this.userDataSource = userDataSource;
	}
	
	private List<User>	userList = new ArrayList<User>();

	public UserListMB()
	{
		
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
