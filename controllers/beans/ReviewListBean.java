package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import models.Review;

/**
 * 
 * @author Ganitzsh
 *
 */
public class ReviewListBean implements Serializable {

	private static final long serialVersionUID = 743855838330123360L;
	
	private List<Review>	userList = new ArrayList<Review>();
	
	public ReviewListBean()
	{
		
	}
	
	public List<Review> getUserList() {
		return userList;
	}
	public void setUserList(List<Review> userList) {
		this.userList = userList;
	}
}
