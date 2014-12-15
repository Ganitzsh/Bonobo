package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean
public class ProductListBean implements Serializable {
	
	private static final long serialVersionUID = 9L;

	private List<ProductBean> productList = new ArrayList<ProductBean>();

	public List<ProductBean> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductBean> productList) {
		this.productList = productList;
	}
}
