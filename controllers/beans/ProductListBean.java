package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import models.Product;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean
public class ProductListBean implements Serializable {

	private static final long serialVersionUID = 1790033715744773751L;
	
	private List<Product> productList = new ArrayList<Product>();

	public ProductListBean()
	{
		
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
