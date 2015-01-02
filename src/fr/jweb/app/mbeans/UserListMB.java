package fr.jweb.app.mbeans;

import java.io.Serializable;
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
@ManagedBean
public class UserListMB implements Serializable {
	
	private UserDAO	userDataSource;
	
	public UserDAO getUserDataSource() {
		return userDataSource;
	}

	public void setUserDataSource(UserDAO userDataSource) {
		this.userDataSource = userDataSource;
	}

	private static final long serialVersionUID = -568316793809037696L;
	
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