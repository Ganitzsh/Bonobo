package fr.jweb.app.mbeans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import fr.jweb.app.daos.NewsDAO;
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
	private NewsDAO		dao = new NewsDAO();
	
	public NewsListMB()
	{
		java.util.Date date= new java.util.Date();
		Timestamp tstamp = new Timestamp(date.getTime());
		
		News tmp1 = new News();
		tmp1.setTitle("Morbi suscipit");
		tmp1.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non lorem in lorem lobortis vehicula vel mollis eros. Aenean pharetra id arcu interdum ultricies. In fringilla purus congue lectus eleifend ornare. Sed suscipit mi nec efficitur tincidunt. Maecenas dignissim, enim at hendrerit porttitor, ligula orci vulputate ipsum, ac ornare augue ligula elementum felis. Nullam ut nulla sit amet lectus hendrerit rhoncus.");
		tmp1.setTimestamp(tstamp);
		
		News tmp2 = new News();
		tmp2.setTitle("Ut consectetur tincidunt");
		tmp2.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non lorem in lorem lobortis vehicula vel mollis eros. Aenean pharetra id arcu interdum ultricies. In fringilla purus congue lectus eleifend ornare. Sed suscipit mi nec efficitur tincidunt. Maecenas dignissim, enim at hendrerit porttitor, ligula orci vulputate ipsum, ac ornare augue ligula elementum felis. Nullam ut nulla sit amet lectus hendrerit rhoncus.");
		tmp2.setTimestamp(tstamp);
		
		News tmp3 = new News();
		tmp3.setTitle("Aliquam in quam");
		tmp3.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non lorem in lorem lobortis vehicula vel mollis eros. Aenean pharetra id arcu interdum ultricies. In fringilla purus congue lectus eleifend ornare. Sed suscipit mi nec efficitur tincidunt. Maecenas dignissim, enim at hendrerit porttitor, ligula orci vulputate ipsum, ac ornare augue ligula elementum felis. Nullam ut nulla sit amet lectus hendrerit rhoncus.");
		tmp3.setTimestamp(tstamp);
		
		newsList.add(tmp1);
		newsList.add(tmp2);
		newsList.add(tmp3);
		newsList.add(tmp2);
		newsList.add(tmp3);
		newsList.add(tmp1);
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
