package edu.pitt.sis.infsci2711.multidbs.vis.dal.orm;

import java.util.Date;

public class Stories {
   private int sid;
   private String connInfo;
   private Date cdate;
   private Date mdate;
   
   public Stories(){
	   
   }
   
   public Stories(int sid, Date cdate, Date mdate){
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
}
