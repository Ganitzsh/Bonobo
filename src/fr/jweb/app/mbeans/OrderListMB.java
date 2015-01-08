package fr.jweb.app.mbeans;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import fr.jweb.app.entities.Order;

@ManagedBean(name="orderList")
@ViewScoped
public class OrderListMB implements Serializable {

	private static final Logger logger = Logger.getLogger(OrderListMB.class);
	private static final long serialVersionUID = 1L;
	
	 @ManagedProperty(value="#{dbManager}")
	 private DatabaseManagerMB dbManager;
	 
	 @ManagedProperty(value="#{currentUser}")
	 private CurrentUserMB currentUser;
	 
	 private List<Order> list = new ArrayList<Order>();

	 public OrderListMB() {
	 }
	 
	 @PostConstruct
	 public void init() {
		 try {
			list = dbManager.getOrderDao().queryBuilder().where().eq("user_id", currentUser.getActualUser().getId()).query();
		} catch (SQLException e) {
			logger.error("SQLException: " + e.getMessage());
			e.printStackTrace();
		}
	 }

	public DatabaseManagerMB getDbManager() {
		return dbManager;
	}

	public void setDbManager(DatabaseManagerMB dbManager) {
		this.dbManager = dbManager;
	}

	public CurrentUserMB getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CurrentUserMB currentUser) {
		this.currentUser = currentUser;
	}

	public List<Order> getList() {
		return list;
	}

	public void setList(List<Order> list) {
		this.list = list;
	}
}
