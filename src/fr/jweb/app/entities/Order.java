package fr.jweb.app.entities;

import java.io.Serializable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@DatabaseField(id = true)
	private long id;
	@DatabaseField(foreign = true, columnName = "user_id")
	private User user;
	@DatabaseField
	private String address;
	@DatabaseField(foreign = true, columnName = "product_id", foreignAutoRefresh = true)
	private Product product;
	@DatabaseField
	private int quantity;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
