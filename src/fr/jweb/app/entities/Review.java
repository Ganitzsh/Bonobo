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
	private String	username;
	@DatabaseField
	private String	review;
	@DatabaseField
	private	int		rating;
	@DatabaseField
	private long	productId;

	public Review()
	{
		
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}


	public String getReviewContent() {
		return review;
	}

	public void setReviewContent(String reviewContent) {
		this.review = reviewContent;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
