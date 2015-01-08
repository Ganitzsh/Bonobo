package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.jweb.app.entities.Product;

/**
 * ProductList ManagedBean
 * Handle the list content of the products
 */
@ManagedBean(name = "products")
@ViewScoped
public class ProductListMB implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;

    private List<Product> productList = new ArrayList<Product>();

    public ProductListMB() {

    }

    @PostConstruct
    public void init() {
        try {
            productList = dbManager.getProductDao().queryForAll();
            dbManager.getConn().close();
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

    /**
     * @param id The product ID
     * @return Redirection to the product reading page
     */
    public String goToProductDescription(long id) {
        return ("single_product?faces-redirect=true&id=" + id);
    }

    /**
     * @param id The id of the wanted product
     * @return Product found with the corresponding ID
     */
    public Product getProductById(long id) {
        for (Product p : productList) {
            if (p.getId() == id)
                return (p);
        }
        return (null);
    }
}
