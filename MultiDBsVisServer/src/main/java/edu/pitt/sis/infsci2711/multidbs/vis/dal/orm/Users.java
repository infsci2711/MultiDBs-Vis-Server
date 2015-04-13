package edu.pitt.sis.infsci2711.multidbs.vis.dal.orm;

import java.util.HashSet;
import java.util.Set;


public class Users {
	
	private Integer userId;
	private String userNames;
	private Set<Canvases> canvasSet = new HashSet<Canvases>(0);
	
	public Users(){
		
	}

	public Users(Integer userId, String userNames, Set<Canvases> canvasSet) {
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
