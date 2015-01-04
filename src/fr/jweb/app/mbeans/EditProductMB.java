package fr.jweb.app.mbeans;

import fr.jweb.app.entities.Product;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.Map;

/**
 * EditProduct ManagedBean
 * Handle the edition of a selected product
 */
@ManagedBean(name = "edit_product")
@ViewScoped
public class EditProductMB {
    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;

    private Product oldProduct;
    private String name;
    private String description;
    private float price;

    /**
     * Initialize the bean
     * Get the id of the Product to edit in the url
     */
    @PostConstruct
    public void _init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        try {
            oldProduct = dbManager.getProductDao().queryForId(Integer.parseInt(requestParams.get("id")));
            name = oldProduct.getName();
            description = oldProduct.getDescription();
            price = oldProduct.getPrice();
        } catch (SQLException e) {
            System.out.println("SQLException while getting product: " + e.getMessage());
        }
    }

    /**
     * Update the Products table with product informations
     *
     * @return Redirection to the administration panel
     */
    public String updateProduct() {
        try {
            oldProduct.setDescription(this.getDescription());
            oldProduct.setPrice(this.getPrice());
            oldProduct.setName(this.getName());
            dbManager.getProductDao().update(oldProduct);
        } catch (SQLException e) {
            System.out.println("SQLException while updating product: " + e.getMessage());
            e.printStackTrace();
        }
        return ("admin?faces-redirect=true");
    }

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }

    public Product getOldProduct() {
        return oldProduct;
    }

    public void setOldProduct(Product oldProduct) {
        this.oldProduct = oldProduct;
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
