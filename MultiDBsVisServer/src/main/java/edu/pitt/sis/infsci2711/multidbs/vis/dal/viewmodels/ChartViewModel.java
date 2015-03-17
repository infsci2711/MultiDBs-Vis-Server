package edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels;

import javax.xml.bind.annotation.XmlRootElement;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;

@XmlRootElement
public class ChartViewModel {
  private int cid;
  private String name;
  private String type;
  private CanvasViewModel canvases;

  public int getCid(){
	  return cid;
  }
  
  public void setCid(int cid){
	  this.cid = cid;
  }
  
  public String getName(){
	  return name;
  }
  
  public void setName(String name){
	  this.name = name;
  }
  
  public String getType(){
	  return type;
  }
  
  public void setType(String type){
	  this.type = type;
  }
 
  public CanvasViewModel getCanvases(){
	  return canvases;
  }
  
  public void setCanvases(CanvasViewModel canvases){
	  this.canvases = canvases;
  }
}
