package edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels;

import java.util.Date;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;

public class StoryViewModel {
	   private int sid;
	   private String connInfo;
	   private Date cdate;
	   private Date mdate;
	   private Users user;
	   
	   public StoryViewModel() {
		   
	   }
	   
	   public StoryViewModel(Users user, Date cdate, Date mdate, String connInfo){
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
	   
	   public Users getUser(){
		   return this.user;
	   }
	   
	   public void setUser(Users user){
		   this.user = user;
	   }
}
