package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean
public class ReviewBean implements Serializable {
	
	private static final long serialVersionUID = 2L;

	private UserBean	sourceUser;
	private String		reviewContent;
	private	int			rating;
	
	public ReviewBean()
	{
		
	}

	public UserBean getSourceUser() {
		return sourceUser;
	}

	public void setSourceUser(UserBean sourceUser) {
		this.sourceUser = sourceUser;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
