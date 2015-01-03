package fr.jweb.app.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import fr.jweb.app.entities.User;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean(name="users")
public class UserListMB {
	
	@ManagedProperty(value="dbManager")
	private DatabaseManagerMB dbManager;
	
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
