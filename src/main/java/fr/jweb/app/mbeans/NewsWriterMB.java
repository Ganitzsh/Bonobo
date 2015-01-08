package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.jweb.app.entities.News;

/**
 * NewsWriter ManagedBean
 * Handle the posting of a new news in the administration panel
 */
@ManagedBean(name = "newsWriter")
@SessionScoped
public class NewsWriterMB implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;
    private String title;
    private String content;

    public NewsWriterMB() {

    }

    /**
     * Post a news in the Database with the given informations
     *
     * @return Redirection to the index
     */
    public String postNews() {
        try {
            News tmp = new News();
            tmp.setContent(content);
            tmp.setTitle(title);
            dbManager.getNewsDao().create(tmp);
            dbManager.getConn().close();
            content = "";
            title = "";
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException: while posting news: " + e.getMessage());
        }
        return ("index");
    }

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
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
