package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import fr.jweb.app.entities.Product;
import fr.jweb.app.entities.Review;

/**
 * ReviewPoster ManagedBean
 * Handle the posting of a new review for a selected product
 */
@ManagedBean(name = "reviewPoster")
@ViewScoped
public class ReviewPosterMB implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(ReviewPosterMB.class);
    
    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;

    @ManagedProperty(value = "#{currentUser}")
    private CurrentUserMB currentUser;

    private String reviewTitle;
    private String reviewContent;
    private Boolean alreadyPosted = false;
    
    public Boolean getAlreadyPosted() {
		return alreadyPosted;
	}

	public void setAlreadyPosted(Boolean alreadyPosted) {
		this.alreadyPosted = alreadyPosted;
	}

	private int rating;

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }

    public int getRating() {
        return rating;
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

    public ReviewPosterMB() {

    }
    
    @PostConstruct
    public void init() {
    	try {
			if (dbManager.getReviewDao().queryBuilder().where().eq("user_id", currentUser.getActualUser().getId()).query().size() > 0)
				alreadyPosted = true;
		} catch (SQLException e) {
			logger.error("SQLException: " + e.getMessage());
			e.printStackTrace();
		}
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

    /**
     * Handle the posting of a new review with the given informations
     *
     * @return redirection to the product with the new review
     */
    public String newReview(Product item) {
        try {
            Review tmp = new Review();
            tmp.setProduct(item);
            tmp.setRating(this.rating);
            tmp.setReviewContent(this.reviewContent);
            tmp.setUser(currentUser.getActualUser());
            dbManager.getReviewDao().create(tmp);
        } catch (SQLException e) {
            System.out.println("SQLException: exception caught while creating review: " + e.getMessage());
            logger.error("SQLException: exception caught while creating review: " + e.getMessage());
            e.printStackTrace();
        }
        return ("single_product?faces-redirect=true&id=" + item.getId());
    }
}
