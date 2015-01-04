package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.jweb.app.entities.Product;
import fr.jweb.app.entities.Review;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean(name="currentProduct")
@SessionScoped
public class CurrentProductMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private Product	actualProduct = new Product();
	private List<Review> reviews = new ArrayList<Review>();
	
	public CurrentProductMB()
	{
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Product getActualProduct() {
		return actualProduct;
	}

	public void setActualProduct(Product actualProduct) {
		this.actualProduct = actualProduct;
	}
}
