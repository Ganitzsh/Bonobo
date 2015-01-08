package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.jweb.app.entities.News;

/**
 * NewsList Managedbean
 * Handle the news list content
 */
@ManagedBean(name = "news")
@ViewScoped
public class NewsListMB implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<News> newsList = new ArrayList<News>();

    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }

    public NewsListMB() {
    }

    @PostConstruct
    public void init() {
        try {
            newsList = dbManager.getNewsDao().queryForAll();
        } catch (SQLException e) {
            System.out.println("SQLException while querying news: " + e.getMessage());
        }
    }

    public String deleteNews(long id) {
    	try {
			dbManager.getNewsDao().deleteById((int) id);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQLException: Could not remove news with id " + id);
		}
    	return ("index?faces-redirect=true");
    }
    
    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
