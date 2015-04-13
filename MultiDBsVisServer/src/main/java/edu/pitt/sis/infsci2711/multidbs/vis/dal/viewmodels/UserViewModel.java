package edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;

@XmlRootElement
public class UserViewModel {
	private Integer userId;
	private String userNames;
	private Set<Canvases> canvasSet = new HashSet<Canvases>(0);
	
    public UserViewModel() {
		// TODO Auto-generated constructor stub
	}
    
    public UserViewModel(Integer userId, String  userNames){
    	this.userId = userId;
    	this.userNames = userNames;
    }

	public UserViewModel(Integer userId, String userNames, Set<Canvases> canvasSet) {
		super();
		this.userId = userId;
		this.userNames = userNames;
		this.canvasSet = canvasSet;
	}


	public Integer getUserId() {
		return userId;
	}



	public void setUserId(Integer userId) {
		this.userId = userId;
	}



	public String getUserNames() {
		return userNames;
	}



	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}



	public Set<Canvases> getCanvasSet() {
		return canvasSet;
	}



	public void setCanvasSet(Set<Canvases> canvasSet) {
		this.canvasSet = canvasSet;
	}

}
