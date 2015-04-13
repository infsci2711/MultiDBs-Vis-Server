package edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ChartViewModelTest {
	
	
		private int cid;
		private String name;
		private String type;
		private int left;
		private int top;
		private int depth;
		private int height;
		private int width;
		private String datainfo;
		private String note;
		
		private CanvasViewModel canvasVM;
		
		private Set<StoryViewModel> stories = new HashSet<StoryViewModel>();
	  
		public ChartViewModelTest() {
		  
		}
		
		public ChartViewModelTest(int cid, String name, String type, int left, int top, int depth, int height,
				int width, String datainfo, CanvasViewModel canvasVM){
			this.cid = cid;
			this.name = name;
			this.type = type;
			this.left = left;
			this.top = top;
			this.depth = depth;
			this.height = height;
			this.width = width;
			this.datainfo = datainfo;
			this.canvasVM = canvasVM;
		}
	  
	  public ChartViewModelTest(Integer cid, String name, String type) {
		this.cid = cid;
		this.name = name;
		this.type = type;
	  }
	  
	  public ChartViewModelTest(CanvasViewModel canvasVM, String name, String type, Integer left, Integer top, Integer depth, Integer height, Integer width, String datainfo) {
			this.canvasVM = canvasVM;
		    //this.cid = cid;
			this.name = name;
			this.type = type;
			this.left = left != null ? left : 0;
			this.top = top != null ? top: 0;
			this.depth = depth != null ? depth : 0;
			this.height = height != null ? height : 0;
			this.width = width != null ? width : 0;
			this.datainfo = datainfo;
			//this.note = note;
			
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
			return canvasVM;
		}

		public void setCanvas(CanvasViewModel canvasVM) {
			this.canvasVM = canvasVM;
		}

		public Set<StoryViewModel> getStories() {
			return stories;
		}

		public void setStories(Set<StoryViewModel> stories) {
			this.stories = stories;
		}
	 

	

}
