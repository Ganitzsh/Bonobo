package fr.jweb.app.mbeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="dbManager")
@SessionScoped
public class DatabaseManagerMB {
	
	private final static String URL = "jdbc:mysql://localhost/jweb";
	private final static String USER = "root";
	private final static String PASS = "root";
	
	private Connection			conn;
	
    // create a connection source to our database
	public DatabaseManagerMB()
	{
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}	
}
