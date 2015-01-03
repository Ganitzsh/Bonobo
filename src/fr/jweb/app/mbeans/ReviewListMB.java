package fr.jweb.app.mbeans;

import java.util.ArrayList;
import java.util.List;

import fr.jweb.app.entities.Review;

import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean
public class ReviewListMB {
	
	private List<Review>	userList = new ArrayList<Review>();
	
	public ReviewListMB()
	{
		
	}
	
	public List<Review> getUserList() {
		return userList;
	}
	public void setUserList(List<Review> userList) {
		this.userList = userList;
	}
}
