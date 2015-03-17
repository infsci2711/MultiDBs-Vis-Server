package edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import edu.pitt.sis.exp.colfusion.utils.Gsonazable;
import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;

<<<<<<< HEAD
public class StoryViewModel {
	private Integer sid;
    private String connInfo;
    private Date cdate;
    private Date mdate;
   
    private UserViewModel user;
   
    public StoryViewModel(){
	   
    }
   
    public StoryViewModel(Integer sid, Date cdate, Date mdate, String connInfo, UserViewModel user){
	    this.setUser(user);
    	this.sid = sid;
	    this.cdate = cdate;
	    this.mdate = mdate;
	    this.connInfo = connInfo;
    }
   
   public int getSid(){
	   return this.sid;
   }
   
   public void setSid(int sid){
	   this.sid = sid;
   }
   
   public String getConnInfo(){
	   return this.connInfo;
   }
   
   public void setConnInfo(String connInfo){
	   this.connInfo = connInfo;
   }
   
   public Date getCdate(){
	   return this.cdate;
   }
   
   public void setCdate(Date cdate){
	   this.cdate = cdate;
   }
   
   public Date getMdate(){
	   return this.mdate;
   }
   
   public void setMdate(Date mdate){
	   this.mdate = mdate;
   }

	public UserViewModel getUser() {
		return user;
	}
	
	public void setUser(UserViewModel user) {
		this.user = user;
	}
   
=======
@XmlRootElement
public class StoryViewModel{
	   private int sid;
	   private String connInfo;
	   private Date cdate;
	   private Date mdate;
	   private UserViewModel user;
	   
	   public StoryViewModel() {
		   
	   }
	   
	   public StoryViewModel(UserViewModel user, Date cdate, Date mdate, String connInfo){
		   this.user = user;
		   this.cdate = cdate;
		   this.mdate = mdate;
		   this.connInfo = connInfo;
	   }
	   
	   public int getSid(){
		   return this.sid;
	   }
	   
	   public void setSid(int sid){
		   this.sid = sid;
	   }
	   
	   public String getConnInfo(){
		   return this.connInfo;
	   }
	   
	   public void setConnInfo(String connInfo){
		   this.connInfo = connInfo;
	   }
	   
	   public Date getCdate(){
		   return this.cdate;
	   }
	   
	   public void setCdate(Date cdate){
		   this.cdate = cdate;
	   }
	   
	   public Date getMdate(){
		   return this.mdate;
	   }
	   
	   public void setMdate(Date mdate){
		   this.mdate = mdate;
	   }
	   
	   public UserViewModel getUser(){
		   return this.user;
	   }
	   
	   public void setUser(UserViewModel user){
		   this.user = user;
	   } 
	   
>>>>>>> origin/master
}
