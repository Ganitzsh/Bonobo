package beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class NewsBean implements Serializable {
	
	private static final long serialVersionUID = 3L;

	private String		title;
	private String		content;
	private	Timestamp	timestamp;
	
	public NewsBean()
	{
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
