package fr.jweb.app.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author Ganitzsh
 *
 */
@DatabaseTable(tableName="review")
public class Review {

	@DatabaseField(id = true)
	private long	id;
	@DatabaseField
	private User	sourceUser;
	@DatabaseField
	private String	reviewContent;
	@DatabaseField
	private	int		rating;
	@DatabaseField
	private int		productId;
	
	public Review()
	{
		
	}
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
