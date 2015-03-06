package edu.pitt.sis.infsci2711.multidbs.vis.dal.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Story {
   private int sid;
   private String connInfo;
   private Date cdate;
   private Date mdate;
   private Users user;
   private Set canvasSet = new HashSet(0);
   private Set chartSet = new HashSet(0);
   
   public Story(){
	   
   }
   
   public Story(Users user, Date cdate, Date mdate, String connInfo){
	   this.cdate = cdate;
	   this.mdate = mdate;
	   this.user = user;
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

  public Set getCanvasSet() {
	return canvasSet;
  }

  public void setCanvasSet(Set canvasSet) {
	this.canvasSet = canvasSet;
  }

  public Set getChartSet() {
	return chartSet;
  }

  public void setChartSet(Set chartSet) {
	this.chartSet = chartSet;
  }
}
