package fr.jweb.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author Ganitzsh
 *
 */
@DatabaseTable(tableName="product")
@ManagedBean(name="currentProduct")
@SessionScoped
public class Product {
	
	private Object anyObject;
	
	public Object getAnyObject() {
		return anyObject;
	}

	public void setAnyObject(Object anyObject) {
		this.anyObject = anyObject;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@DatabaseField(id = true)
	private long	id = 0;
	private String	name = "Dummy object";
	private	String	description = "Tu peux pas test maggle";
	private float	price = (float) 999.99;
	private List<Review>	reviews = new ArrayList<Review>();
	
	public Product()
	{
		
	}
	
	@PostConstruct
    public void init() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        this.anyObject = ec.getRequestMap().get("anyObject");
        Product tmp = (Product) this.anyObject;
        System.out.println("Current shit name: " + tmp);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
