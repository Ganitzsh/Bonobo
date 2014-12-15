package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean
public class NewsListBean implements Serializable {
	
	private static final long serialVersionUID = 6L;
	
	private List<NewsBean>	newsList = new ArrayList<NewsBean>();
	
	public NewsListBean()
	{
		// TODO: Requests every news from web-service and allocate array
	}

	public List<NewsBean> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<NewsBean> newsList) {
		this.newsList = newsList;
	}
}
