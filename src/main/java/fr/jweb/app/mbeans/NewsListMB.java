package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import fr.jweb.app.entities.News;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean
public class NewsListMB implements Serializable {
	
	private static final long serialVersionUID = -4747832241684935467L;
	private List<News>	newsList = new ArrayList<News>();
	
	public NewsListMB()
	{
		// TODO: Requests every news from web-service and allocate array
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
}
