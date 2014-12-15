package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean
public class UserListBean implements Serializable {

	private static final long serialVersionUID = 8L;

	private List<UserBean>	userList = new ArrayList<UserBean>();

	public List<UserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}
}
