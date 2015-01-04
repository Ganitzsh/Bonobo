package fr.jweb.app.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.sql.SQLException;

@ManagedBean(name="administration")
@SessionScoped
public class AdministrationMB {

    @ManagedProperty(value="#{dbManager}")
    private DatabaseManagerMB dbManager;

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }

    public String deleteUser(int id) {
        try {
            dbManager.getUserDao().delete(dbManager.getUserDao().queryForId(id));
        }
        catch (SQLException e) {
            System.out.println("SQLException while deleting user: " + e.getMessage());
        }
        return ("admin?faces-redirect=true");
    }
    public String editUser(int id) {
        return ("edit_user?id=" + id + "&faces-redirect=true");
    }
    public String deleteNews(int id) {
        try {
            dbManager.getNewsDao().delete(dbManager.getNewsDao().queryForId(id));
        }
        catch (SQLException e) {
            System.out.println("SQLException while deleting user: " + e.getMessage());
        }
        return ("admin?faces-redirect=true");
    }
    public String editNews(int id) {
        return ("edit_news?id=" + id + "&faces-redirect=true");
    }
    public String deleteProduct(int id) {
        try {
            dbManager.getProductDao().delete(dbManager.getProductDao().queryForId(id));
        }
        catch (SQLException e) {
            System.out.println("SQLException while deleting user: " + e.getMessage());
        }
        return ("admin?faces-redirect=true");
    }
    public String editProduct(int id) {
        return ("edit_product?id=" + id + "&faces-redirect=true");
    }

}
