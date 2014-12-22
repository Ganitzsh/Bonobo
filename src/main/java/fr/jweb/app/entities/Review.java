package fr.jweb.app.entities;

/**
 * 
 * @author Ganitzsh
 *
 */
public class Review {

	private User	sourceUser;
	private String	reviewContent;
	private	int		rating;
	
	public Review()
	{
		
	}

	public User getSourceUser() {
		return sourceUser;
	}

	public void setSourceUser(User sourceUser) {
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
}
