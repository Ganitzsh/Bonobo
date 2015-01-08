package fr.jweb.app.mbeans;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import fr.jweb.app.common.MailSender;
import fr.jweb.app.entities.News;
import fr.jweb.app.entities.Order;
import fr.jweb.app.entities.Product;
import fr.jweb.app.entities.Review;

import java.io.Serializable;
import java.sql.SQLException;

import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;

import fr.jweb.app.entities.User;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.apache.log4j.Logger;

/**
 * DatabaseManager ManagedBean
 * Handle the connection with the database
 * Contain the DAO for each entities : News, Product, Review, User
 */
@ManagedBean(name = "dbManager")
@ApplicationScoped
public class DatabaseManagerMB implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(DatabaseManagerMB.class);

    private final static String URL = "jdbc:mysql://localhost/jweb";
    private final static String USER = "root";
    private final static String PASS = null;

    private Dao<Review, Integer> reviewDao;
    private Dao<User, Integer> userDao;
    private Dao<News, Integer> newsDao;
    private Dao<Product, Integer> productDao;
    private Dao<Order, Integer> orderDao;
    
    private MailSender mailSender;
    
    private ConnectionSource conn;

    /**
     * DatabaseManager ManagedBean constructor
     * Initialize the connection with the database
     * Creates DAO's
     */
    public DatabaseManagerMB() {
        try {
            conn = new JdbcConnectionSource(URL, USER, PASS);
            reviewDao = DaoManager.createDao(conn, Review.class);
            userDao = DaoManager.createDao(conn, User.class);
            newsDao = DaoManager.createDao(conn, News.class);
            productDao = DaoManager.createDao(conn, Product.class);
            orderDao = DaoManager.createDao(conn, Order.class);
            mailSender = new MailSender();
            logger.info("Database connection established successfully");
        } catch (SQLException ex) {
        	logger.error("SQLException: " + ex.getMessage());
        	logger.error("SQLState: " + ex.getSQLState());
        	logger.error("VendorError: " + ex.getErrorCode());
        }
    }

    public MailSender getMailSender() {
		return mailSender;
	}


	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}


	public Dao<Order, Integer> getOrderDao() {
		return orderDao;
	}


	public void setOrderDao(Dao<Order, Integer> orderDao) {
		this.orderDao = orderDao;
	}


	public static String getUrl() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPass() {
        return PASS;
    }

    public Dao<Review, Integer> getReviewDao() {
        return reviewDao;
    }

    public void setReviewDao(Dao<Review, Integer> reviewDao) {
        this.reviewDao = reviewDao;
    }

    public Dao<User, Integer> getUserDao() {
        return userDao;
    }

    public void setUserDao(Dao<User, Integer> userDao) {
        this.userDao = userDao;
    }

    public Dao<News, Integer> getNewsDao() {
        return newsDao;
    }

    public void setNewsDao(Dao<News, Integer> newsDao) {
        this.newsDao = newsDao;
    }

    public Dao<Product, Integer> getProductDao() {
        return productDao;
    }

    public void setProductDao(Dao<Product, Integer> productDao) {
        this.productDao = productDao;
    }

    public ConnectionSource getConn() {
        return conn;
    }

    public void setConn(ConnectionSource conn) {
        this.conn = conn;
    }
}
