package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * 
 * @author Ganitzsh
 *
 */
@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {
	private static final long serialVersionUID = 5L;
	 
	private String name;
 
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
