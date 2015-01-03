package fr.jweb.app.mbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
	
	@ManagedProperty(value="#{dbManager}")
	private DatabaseManagerMB dbManager;
	
	@ManagedProperty(value="#{currentProduct}")
	private CurrentProductMB currentProduct;

	private List<Product> productList = new ArrayList<Product>();
	
	public ProductListMB()
	{
		
	}
	
	@PostConstruct
	public void init()
	{
		try {
			productList = dbManager.getProductDao().queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DatabaseManagerMB getDbManager() {
		return dbManager;
	}

	public void setDbManager(DatabaseManagerMB dbManager) {
		this.dbManager = dbManager;
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public String goToProductDescription(long id) {
		Product tmp = getProductById(id);
		currentProduct.getActualProduct().setName(tmp.getName());
		currentProduct.getActualProduct().setDescription(tmp.getDescription());
		currentProduct.getActualProduct().setId(tmp.getId());
		currentProduct.getActualProduct().setPrice(tmp.getPrice());
		return ("single_product?faces-redirect=true");
	}


	public CurrentProductMB getCurrentProduct() {
		return currentProduct;
	}

	public void setCurrentProduct(CurrentProductMB currentProduct) {
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
