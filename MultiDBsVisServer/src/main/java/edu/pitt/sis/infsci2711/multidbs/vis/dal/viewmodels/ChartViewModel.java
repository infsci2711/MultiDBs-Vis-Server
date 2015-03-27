package edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ChartViewModel {
	private Integer cid;
	private String name;
	private String type;
	private Integer left;
	private Integer top;
	private Integer depth;
	private Integer height;
	private Integer width;
	private String datainfo;
	private String note;
	
	private CanvasViewModel canvas;
	
	private Set<StoryViewModel> stories = new HashSet<StoryViewModel>();
  
	public ChartViewModel() {
	  
	}
  
  public ChartViewModel(Integer cid, String name, String type) {
	this.cid = cid;
	this.name = name;
	this.type = type;
  }
  
  public ChartViewModel(CanvasViewModel canvasVM, String name, String type, Integer left, Integer top, Integer depth, Integer height, Integer width, String datainfo) {
		this.canvas = canvasVM;
		this.left = left != null ? left : 0;
		this.top = top != null ? top: 0;
		this.depth = depth != null ? depth : 0;
		this.height = height != null ? height : 0;
		this.width = width != null ? width : 0;
		this.datainfo = datainfo;
		
	}

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

	public int getLeft() {
		return left;
	}
	
	public void setLeft(int left) {
		this.left = left;
	}
	
	public int getTop() {
		return top;
	}
	
	public void setTop(int top) {
		this.top = top;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public String getDatainfo() {
		return datainfo;
	}
	
	public void setDatainfo(String datainfo) {
		this.datainfo = datainfo;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}

	public CanvasViewModel getCanvas() {
		return canvas;
	}

	public void setCanvas(CanvasViewModel canvasVM) {
		this.canvas = canvasVM;
	}

	public Set<StoryViewModel> getStories() {
		return stories;
	}

	public void setStories(Set<StoryViewModel> stories) {
		this.stories = stories;
	}
 

}
