package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import models.User;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean
public class UserListBean implements Serializable {
	
	private static final long serialVersionUID = -568316793809037696L;
	
	private List<User>	userList = new ArrayList<User>();

	public UserListBean()
	{
		
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
