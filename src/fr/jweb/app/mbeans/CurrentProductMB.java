package fr.jweb.app.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.jweb.app.entities.Product;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean(name="currentProduct")
@SessionScoped
public class CurrentProductMB {

	private Product	actualProduct = new Product();
	
	public CurrentProductMB()
	{
	}

	public Product getActualProduct() {
		return actualProduct;
	}

	public void setActualProduct(Product actualProduct) {
		this.actualProduct = actualProduct;
	}
}
