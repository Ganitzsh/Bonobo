package fr.jweb.app.mbeans;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.jweb.app.entities.News;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean(name="news")
@ViewScoped
public class NewsListMB {

	private List<News>	newsList = new ArrayList<News>();
	
	@ManagedProperty(value="#{dbManager}")
	private DatabaseManagerMB dbManager;
	
	public DatabaseManagerMB getDbManager() {
		return dbManager;
	}

	public void setDbManager(DatabaseManagerMB dbManager) {
		this.dbManager = dbManager;
	}
	
	public NewsListMB()
	{
		
	}
	
	@PostConstruct
	public void init() {
		try {
			System.out.println("OMG c'est executé :D");
			newsList = dbManager.getNewsDao().queryForAll();
		} catch (SQLException e) {
			System.out.println("SQLException while querying news: " + e.getMessage());
		}
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
}
