package fr.jweb.app.mbeans;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import fr.jweb.app.entities.News;
import fr.jweb.app.entities.Product;
import fr.jweb.app.entities.Review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import fr.jweb.app.entities.User;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="dbManager")
@SessionScoped
public class DatabaseManagerMB {
	
	private final static String URL = "jdbc:mysql://localhost/jweb";
	private final static String USER = "root";
	private final static String PASS = "root";

	private Dao<Review, Integer> reviewDao;
	private Dao<User, Integer> userDao;
	private Dao<News, Integer> newsDao;
	private Dao<Product, Integer> productDao;

	private ConnectionSource conn;

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

	// create a connection source to our database
	public DatabaseManagerMB()
	{
		try {
			conn = new JdbcConnectionSource(URL, USER, PASS);
			reviewDao = DaoManager.createDao(conn, Review.class);
			userDao = DaoManager.createDao(conn, User.class);
			newsDao = DaoManager.createDao(conn, News.class);
			productDao = DaoManager.createDao(conn, Product.class);
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public ConnectionSource getConn() {
		return conn;
	}

	public void setConn(ConnectionSource conn) {
		this.conn = conn;
	}
}
