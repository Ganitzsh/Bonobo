package fr.jweb.app.mbeans;

import fr.jweb.app.entities.Review;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.Map;

/**
 * EditReview ManagedBean
 * Handle the edition the a selected review
 */
@ManagedBean(name = "edit_review")
@ViewScoped
public class EditReviewMB {
    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;

    private String reviewContent;
    private int    rating;
    private Review  oldReview;

    /**
     * Initialize the bean
     * Get the id of the Review to edit in the url
     */
    @PostConstruct
    public void _init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        try {
            oldReview = dbManager.getReviewDao().queryForId(Integer.parseInt(requestParams.get("id")));
            reviewContent = oldReview.getReviewContent();
            rating = oldReview.getRating();
            dbManager.getConn().close();
        } catch (SQLException e) {
            System.out.println("SQLException while getting review: " + e.getMessage());
        }
    }
    /**
     * Update the News table with news informations
     * @return Redirection to the administration panel
     */
    public String updateReview() {
        try {
            oldReview.setReview(this.getReviewContent());
            oldReview.setRating(this.getRating());
            dbManager.getReviewDao().update(oldReview);
        } catch (SQLException e) {
            System.out.println("SQLException while updating review: " + e.getMessage());
            e.printStackTrace();
        }
        return ("admin?faces-redirect=true");
    }
    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
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

    public Review getOldReview() {
        return oldReview;
    }

    public void setOldReview(Review oldReview) {
        this.oldReview = oldReview;
    }
}
