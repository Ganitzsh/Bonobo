package fr.jweb.app.mbeans;

import fr.jweb.app.entities.News;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.sql.SQLException;
import java.util.Map;

/**
 * EditNews ManagedBean
 * Handle the edition the a selected news
 */
@ManagedBean(name = "edit_news")
@ViewScoped
public class EditNewsMB {

    @ManagedProperty(value = "#{dbManager}")
    private DatabaseManagerMB dbManager;

    private News oldNews;
    private String title;
    private String content;

    /**
     * Initialize the bean
     * Get the id of the News to edit in the url
     */
    @PostConstruct
    public void _init() {
        Map<String, String> requestParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        try {
            oldNews = dbManager.getNewsDao().queryForId(Integer.parseInt(requestParams.get("id")));
            title = oldNews.getTitle();
            content = oldNews.getContent();
        } catch (SQLException e) {
            System.out.println("SQLException while getting news: " + e.getMessage());
        }
    }

    /**
     * Update the News table with news informations
     * @return Redirection to the administration panel
     */
    public String updateNews() {
        try {
            oldNews.setTitle(this.getTitle());
            oldNews.setContent(this.getContent());
            dbManager.getNewsDao().update(oldNews);
        } catch (SQLException e) {
            System.out.println("SQLException while updating news: " + e.getMessage());
            e.printStackTrace();
        }
        return ("admin?faces-redirect=true");
    }

    public DatabaseManagerMB getDbManager() {
        return dbManager;
    }

    public void setDbManager(DatabaseManagerMB dbManager) {
        this.dbManager = dbManager;
    }

    public News getOldNews() {
        return oldNews;
    }

    public void setOldNews(News oldNews) {
        this.oldNews = oldNews;
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
