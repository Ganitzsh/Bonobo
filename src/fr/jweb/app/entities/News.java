package fr.jweb.app.entities;

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
	
	public News()
	{
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
}
