package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import fr.jweb.app.entities.Order;
import fr.jweb.app.entities.Product;

@ManagedBean(name="order")
@ViewScoped
public class OrderMB implements Serializable {

	private static final Logger logger = Logger.getLogger(OrderMB.class);
	private static final long serialVersionUID = 1L;

	private String address;
	private String title;
	private int	shipment;
	private int quantity;
	
	public CurrentUserMB getCurrentUser() {
		return currentUser;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCurrentUser(CurrentUserMB currentUser) {
		this.currentUser = currentUser;
	}

	private long productId;
	private Product product;
	
	@ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;
	
	@ManagedProperty(value = "#{currentUser}")
    private CurrentUserMB currentUser;
	
	public OrderMB() {
	}
	
	@PostConstruct
	public void init() {
		Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
    	if (requestParams.get("id") != null) {
    		productId = Integer.parseInt(requestParams.get("id"));
    		try {
				product = dbManager.getProductDao().queryForId((int) productId);
				if (product != null) {
					title = "Ordering " + product.getName();
				}
			} catch (SQLException e) {
				logger.error("SQLException: " + e.getMessage());
				e.printStackTrace();
			}
    	}
	}
	
	public String newOrder() {
		logger.info("Ordering item with id: " + product.getId());
		if (product == null) {
			logger.error("Null product!");
			return ("index?faces-redirect=true");
		}
		if (product != null && quantity > product.getQuantity())
			return ("index?faces-redirect=true");
		else {
			Order tmp = new Order();
			tmp.setProduct(product);
			tmp.setUser(currentUser.getActualUser());
			tmp.setQuantity(quantity);
			tmp.setAddress(address);
			product.setQuantity(product.getQuantity() - quantity);
			String[] to = {currentUser.getActualUser().getEmail()};
			dbManager.getMailSender().sendMail("Order" , "You ordered " + quantity + " units of " + product.getName(), to);
			try {
				dbManager.getOrderDao().create(tmp);
				dbManager.getProductDao().update(product);
				dbManager.getConn().close();
			} catch (SQLException e) {
				logger.error("SQLException: " + e.getMessage());
				e.printStackTrace();
			}
		}
		return ("index?faces-redirect=true");
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getShipment() {
		return shipment;
	}
	
	public void setShipment(int shipment) {
		this.shipment = shipment;
	}
	
	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public DatabaseManagerMB getDbManager() {
		return dbManager;
	}

	public void setDbManager(DatabaseManagerMB dbManager) {
		this.dbManager = dbManager;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
