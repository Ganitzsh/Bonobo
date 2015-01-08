package fr.jweb.app.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Review model class
 * Contains some content and a rating
 * It is also associated with a product with a product PK
 */
@DatabaseTable(tableName = "review")
public class Review {

    @DatabaseField(id = true)
    private long id;
    @DatabaseField
    private String review;
    @DatabaseField
    private int rating;
    @DatabaseField(foreign = true, columnName="product_id")
    private Product product;
    @DatabaseField(foreign = true, columnName="user_id", foreignAutoRefresh=true)
    private User user;

	/**
     * Review model constructor
     */
    public Review() {

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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
