package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.jweb.app.entities.Product;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean
public class ProductListMB implements Serializable {

	private static final long serialVersionUID = 1790033715744773751L;
	
	private List<Product> productList = new ArrayList<Product>();

	public ProductListMB()
	{
		
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
