package fr.jweb.app.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.sql.SQLException;

/**
 * Administration managedBean
 * Handle the administration panel, allowing the administrator to edit the site content and users
 */
@ManagedBean(name = "administration")
@SessionScoped
public class AdministrationMB {

    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }

    /**
     * @param id Id of the user to delete
     * @return Redirection to the administration panel
     */
    public String deleteUser(int id) {
        try {
            dbManager.getUserDao().delete(dbManager.getUserDao().queryForId(id));
        } catch (SQLException e) {
            System.out.println("SQLException while deleting user: " + e.getMessage());
        }
        return ("admin?faces-redirect=true");
    }

    /**
     * @param id id of the user to edit
     * @return Redirection to the administration panel
     */
    public String editUser(int id) {
        return ("edit_user?id=" + id + "&faces-redirect=true");
    }

    /**
     * @param id id of the news to delete
     * @return Redirection to the administration panel
     */
    public String deleteNews(int id) {
        try {
            dbManager.getNewsDao().delete(dbManager.getNewsDao().queryForId(id));
        } catch (SQLException e) {
            System.out.println("SQLException while deleting news: " + e.getMessage());
        }
        return ("admin?faces-redirect=true");
    }

    /**
     * @param id of the news to edit
     * @return Redirection to the administration panel
     */
    public String editNews(int id) {
        return ("edit_news?id=" + id + "&faces-redirect=true");
    }

    /**
     * @param id of the product to delete
     * @return Redirection to the administration panel
     */
    public String deleteProduct(int id) {
        try {
            dbManager.getProductDao().delete(dbManager.getProductDao().queryForId(id));
        } catch (SQLException e) {
            System.out.println("SQLException while deleting product: " + e.getMessage());
        }
        return ("admin?faces-redirect=true");
    }

    /**
     * @param id id of the product to edit
     * @return Redirection to the administration panel
     */
    public String editProduct(int id) {
        return ("edit_product?id=" + id + "&faces-redirect=true");
    }
    /**
     * @param id of the review to delete
     * @return Redirection to the administration panel
     */
    public String deleteReview(int id) {
        try {
            dbManager.getReviewDao().delete(dbManager.getReviewDao().queryForId(id));
        } catch (SQLException e) {
            System.out.println("SQLException while deleting review: " + e.getMessage());
        }
        return ("admin?faces-redirect=true");
    }

    /**
     * @param id id of the review to edit
     * @return Redirection to the administration panel
     */
    public String editReview(int id) {
        return ("edit_review?id=" + id + "&faces-redirect=true");
    }

}
