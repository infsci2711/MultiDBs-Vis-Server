package edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;

@XmlRootElement
public class CanvasViewModel {
   
	private int vid;
	private String name;
	private Date cdate;
	private Date mdate;
	private int privilege;
	private UserViewModel users;
	
	public int getVid(){
		return vid;
	}
	
	public void setVid(final int vid){
		this.vid = vid;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(final String name){
		this.name = name;
	}
	
	public Date getCdate(){
		return cdate;
	}
	
	public void setCdate(final Date cdate){
		this.cdate = cdate;
	}
	
	public Date getMdate(){
		return mdate;
	}
	
	public void setMdate(final Date mdate){
		this.mdate = mdate;
	}
	
	public int getPrivilege(){
		return privilege;
	}
	
	public void setPrivilege(final int privilege){
		this.privilege = privilege;
	}
	
	public UserViewModel getUsers(){
		return users;
	}
	
	public void setUsers(final UserViewModel users){
		this.users = users;
	}
}
