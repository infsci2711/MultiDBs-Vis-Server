package edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels;

import java.util.Date;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Users;

public class StoryViewModel {
	   private int sid;
	   private String connInfo;
	   private Date cdate;
	   private Date mdate;
	   private Users users;
	   
	   public StoryViewModel() {
		   
	   }
	   
	   public StoryViewModel(int sid, Date cdate, Date mdate){
		   this.sid = sid;
		   this.cdate = cdate;
		   this.mdate = mdate;
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
		   return this.users;
	   }
	   
	   public void setUser(Users users){
		   this.users = users;
	   }
}
