package fr.jweb.app.entities;

import java.sql.Timestamp;

/**
 * 
 * @author ganich_j
 *
 */

public class News {

	private String		title;
	private String		content;
	private	Timestamp	timestamp;
	
	public News()
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
}
