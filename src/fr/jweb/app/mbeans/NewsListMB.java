package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.jweb.app.daos.NewsDAO;
import fr.jweb.app.entities.News;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean(name="nList")
@RequestScoped
public class NewsListMB implements Serializable {
	
	private static final long serialVersionUID = -4747832241684935467L;
	private List<News>	newsList = new ArrayList<News>();
	private NewsDAO		dao = new NewsDAO();
	
	public NewsListMB()
	{
		// TODO: Requests every news from web-service and allocate array with DAO
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public NewsDAO getDao() {
		return dao;
	}

	public void setDao(NewsDAO dao) {
		this.dao = dao;
	}
}
