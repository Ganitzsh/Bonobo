package fr.jweb.app.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.security.Timestamp;

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
	private int		userId;
	@DatabaseField
	private String	reviewContent;
	@DatabaseField
	private	int		rating;
	@DatabaseField
	private int		productId;
	@DatabaseField
	private Timestamp posted;

	public Review()
	{
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Timestamp getPosted() {
		return posted;
	}

	public void setPosted(Timestamp posted) {
		this.posted = posted;
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
