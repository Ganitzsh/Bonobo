package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import fr.jweb.app.entities.Product;
import fr.jweb.app.entities.Review;

/**
 * ProductPage ManagedBean
 * Handle the display of a single product informations
 */
@ManagedBean(name = "productPage")
@ViewScoped
public class ProductPageMB implements Serializable {

    private static final long serialVersionUID = 1L;

    final static Logger logger = Logger.getLogger(ProductPageMB.class);
    
    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;
    
    @ManagedProperty(value = "#{currentUser}")
    private CurrentUserMB currentUser;

    private Product product;
    private String	title;
    private Boolean alreadyPosted = false;
    private Review currentUserReview = null;
	private List<Review> reviews = new ArrayList<Review>();

	public Boolean getAlreadyPosted() {
		return alreadyPosted;
	}

	public void setAlreadyPosted(Boolean alreadyPosted) {
		this.alreadyPosted = alreadyPosted;
	}
	
    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductPageMB() {

    }

    /**
     * Query the database for the selected product
     */
    @PostConstruct
    public void init() {
    	Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    	if (requestParams.get("id") != null) {
	        try {
	        	List<Review> tmp = dbManager.getReviewDao().queryBuilder().where().eq("user_id", currentUser.getActualUser().getId()).query();
	        	if (tmp.size() > 0) {
	    			alreadyPosted = true;
	    			currentUserReview = tmp.get(0);
	        	}
				product = dbManager.getProductDao().queryForId(Integer.parseInt(requestParams.get("id")));
				title = (product == null) ? "No product found" : product.getName();
	            reviews = dbManager.getReviewDao().queryBuilder().where().eq("product_id", product.getId()).query();
	            dbManager.getConn().close();
	        } catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
    	}
    	else {
    		title = "Not found";
    		logger.error("Missing id inside request");
    	}
    }

    public String order(long id) {
    	return ("order?faces-redirect=true&id=" + id);
    }
    
	public Review getCurrentUserReview() {
		return currentUserReview;
	}

	public void setCurrentUserReview(Review currentUserReview) {
		this.currentUserReview = currentUserReview;
	}

	public CurrentUserMB getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CurrentUserMB currentUser) {
		this.currentUser = currentUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
