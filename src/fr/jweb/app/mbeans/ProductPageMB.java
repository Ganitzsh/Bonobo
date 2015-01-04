package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.jweb.app.entities.Product;
import fr.jweb.app.entities.Review;

/**
 * ProductPage ManagedBean
 * Handle the display of a single product informations
 */
@ManagedBean(name = "productPage")
@ViewScoped
public class ProductPageMB implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;

    @ManagedProperty(value = "#{currentProduct}")
    private CurrentProductMB currentProduct;

    private Product product;
    private List<Review> reviews = new ArrayList<Review>();

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public CurrentProductMB getCurrentProduct() {
        return currentProduct;
    }

    public void setCurrentProduct(CurrentProductMB currentProduct) {
        this.currentProduct = currentProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductPageMB() {

    }

    /**
     * Query the database for the selected product
     */
    @PostConstruct
    public void init() {
        product = currentProduct.getActualProduct();
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("productId", currentProduct.getActualProduct().getId());
            reviews = dbManager.getReviewDao().queryForFieldValues(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
