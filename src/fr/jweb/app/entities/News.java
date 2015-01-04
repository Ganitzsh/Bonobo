package fr.jweb.app.entities;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * News Model class
 * Contains and id, a title, some content and a publication date
 */
@DatabaseTable(tableName = "news")
public class News {

<<<<<<< Updated upstream
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
=======
    @DatabaseField(id = true)
    private long id;
    @DatabaseField(canBeNull = false)
    private String title;
    @DatabaseField(canBeNull = false)
    private String content;
    @DatabaseField(canBeNull = false)
    private Timestamp timestamp;

    /**
     * News Model constructor
     */
    public News() {

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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
>>>>>>> Stashed changes
}
