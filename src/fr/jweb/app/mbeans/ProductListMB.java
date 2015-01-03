package fr.jweb.app.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.jweb.app.entities.Product;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean(name="products")
@ViewScoped
public class ProductListMB {
	
//	@ManagedProperty(value="dbManager")
//	private DatabaseManagerMB dbManager;
	private List<Product> productList = new ArrayList<Product>();
	
	@ManagedProperty(value="#{currentProduct}")
	private Product currentProduct;

	public ProductListMB()
	{
		Product tmp1 = new Product();
		Product tmp2 = new Product();
		
		tmp1.setId(1);
		tmp1.setName("First!");
		tmp2.setId(2);
		tmp2.setName("Second!");
		productList.add(tmp1);
		productList.add(tmp2);
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public String goToProductDescription(long id) {
		Product tmp = getProductById(id);
		currentProduct.setName(tmp.getName());
		currentProduct.setDescription(tmp.getDescription());
		currentProduct.setId(tmp.getId());
		currentProduct.setPrice(tmp.getPrice());
		currentProduct.setReviews(tmp.getReviews());
		return ("single_product?faces-redirect=true");
	}

	public Product getCurrentProduct() {
		return currentProduct;
	}

	public void setCurrentProduct(Product currentProduct) {
		this.currentProduct = currentProduct;
	}

	public Product getProductById(long id) {
		for (Product p : productList) {
			if (p.getId() == id)
				return (p);
		}
		return (null);
	}
}
