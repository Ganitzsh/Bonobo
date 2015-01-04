package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.jweb.app.entities.Review;

@ManagedBean(name="reviewPoster")
@ViewScoped
public class ReviewPosterMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{dbManager}")
	private DatabaseManagerMB dbManager;
	
	@ManagedProperty(value="#{currentProduct}")
	private CurrentProductMB currentProduct;
	
	@ManagedProperty(value="#{currentUser}")
	private CurrentUserMB currentUser;
	
	private String	reviewTitle;
	private String	reviewContent;
	private int		rating;
	
	public DatabaseManagerMB getDbManager() {
		return dbManager;
	}

	public void setDbManager(DatabaseManagerMB dbManager) {
		this.dbManager = dbManager;
	}

	public int getRating() {
		return rating;
	}

	public CurrentProductMB getCurrentProduct() {
		return currentProduct;
	}

	public void setCurrentProduct(CurrentProductMB currentProduct) {
		this.currentProduct = currentProduct;
	}

	public CurrentUserMB getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CurrentUserMB currentUser) {
		this.currentUser = currentUser;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public ReviewPosterMB()
	{
		
	}
	
	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	
	public String newReview() {
		try {
			Review tmp = new Review();
			tmp.setProductId(currentProduct.getActualProduct().getId());
			tmp.setRating(this.rating);
			tmp.setReviewContent(this.reviewContent);
			tmp.setUsername(currentUser.getActualUser().getUsername());
			dbManager.getReviewDao().create(tmp);
		} catch (SQLException e) {
			System.out.println("SQLException: exception caught while creating review: " + e.getMessage());
			e.printStackTrace();
		}
		return ("single_product");
	}
}
