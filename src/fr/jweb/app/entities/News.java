package fr.jweb.app.entities;

import java.sql.Timestamp;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * 
 * @author ganich_j
 *
 */
@DatabaseTable(tableName="news")
public class News {

	@DatabaseField(id = true)
	private long		id;
	@DatabaseField(canBeNull = false)
	private String		title;
	@DatabaseField(canBeNull = false)
	private String		content;
	@DatabaseField(canBeNull = true)
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
