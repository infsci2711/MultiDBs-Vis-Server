package edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels;

<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;
=======
import javax.xml.bind.annotation.XmlRootElement;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Canvases;
>>>>>>> origin/master

@XmlRootElement
public class ChartViewModel {
<<<<<<< HEAD
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
  
  public ChartViewModel(String name, String type, Integer left, Integer top, Integer depth,
			Integer height, Integer width, String datainfo, String note, 
			CanvasViewModel canvas, Set<StoryViewModel> stories) {
		this.canvas = canvas;
		this.name = name;
		this.type = type;
		this.left = left;
		this.top = top;
		this.depth = depth;
		this.height = height;
		this.width = width;
		this.datainfo = datainfo;
		this.note = note;
		this.stories = stories;
	}
=======
  private int cid;
  private String name;
  private String type;
  private CanvasViewModel canvases;
>>>>>>> origin/master

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

	public Integer getLeft() {
		return left;
	}
	
	public void setLeft(int left) {
		this.left = left;
	}
	
	public Integer getTop() {
		return top;
	}
	
	public void setTop(int top) {
		this.top = top;
	}
	
	public Integer getDepth() {
		return depth;
	}
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	public Integer getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public Integer getWidth() {
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

	public void setCanvas(CanvasViewModel canvas) {
		this.canvas = canvas;
	}

	public Set<StoryViewModel> getStories() {
		return stories;
	}

	public void setStories(Set<StoryViewModel> stories) {
		this.stories = stories;
	}
 
<<<<<<< HEAD

=======
  public CanvasViewModel getCanvases(){
	  return canvases;
  }
  
  public void setCanvases(CanvasViewModel canvases){
	  this.canvases = canvases;
  }
>>>>>>> origin/master
}
