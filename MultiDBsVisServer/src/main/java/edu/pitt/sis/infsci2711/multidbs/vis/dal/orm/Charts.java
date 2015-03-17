package edu.pitt.sis.infsci2711.multidbs.vis.dal.orm;

import java.util.HashSet;
import java.util.Set;

	public class Charts implements java.io.Serializable {

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
<<<<<<< HEAD
		
		private Canvases canvases;
		
		private Set<Story> storySet = new HashSet(0);
=======
		private Set storySet = new HashSet(0);
>>>>>>> origin/master

		public Charts() {		
		}

		public Charts(Canvases canvases, String name,
				String type, Integer left, Integer top, Integer depth,
				Integer height, Integer width, String datainfo, String note) {
			this.canvases = canvases;
			this.name = name;
			this.type = type;
			this.left = left;
			this.top = top;
			this.depth = depth;
			this.height = height;
			this.width = width;
			this.datainfo = datainfo;
			this.note = note;
		}
		
		public Charts(Canvases canvases, String name,
				String type, Integer left, Integer top, Integer depth,
				Integer height, Integer width, String datainfo, String note, Set<Story> storySet) {
			this.canvases = canvases;
			this.name = name;
			this.type = type;
			this.left = left;
			this.top = top;
			this.depth = depth;
			this.height = height;
			this.width = width;
			this.datainfo = datainfo;
			this.note = note;
			this.storySet = storySet;
		}

		public Integer getCid() {
			return this.cid;
		}

		public void setCid(Integer cid) {
			this.cid = cid;
		}

		public Canvases getCanvases() {
			return this.canvases;
		}

		public void setCanvases(Canvases canvases) {
			this.canvases = canvases;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return this.type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Integer getLeft() {
			return this.left;
		}

		public void setLeft(Integer left) {
			this.left = left;
		}

		public Integer getTop() {
			return this.top;
		}

		public void setTop(Integer top) {
			this.top = top;
		}

		public Integer getDepth() {
			return this.depth;
		}

		public void setDepth(Integer depth) {
			this.depth = depth;
		}

		public Integer getHeight() {
			return this.height;
		}

		public void setHeight(Integer height) {
			this.height = height;
		}

		public Integer getWidth() {
			return this.width;
		}

		public void setWidth(Integer width) {
			this.width = width;
		}

		public String getDatainfo() {
			return this.datainfo;
		}

		public void setDatainfo(String datainfo) {
			this.datainfo = datainfo;
		}

		public String getNote() {
			return this.note;
		}

		public void setNote(String note) {
			this.note = note;
		}

<<<<<<< HEAD
		public Set<Story> getStorySet() {
			return storySet;
		}

		public void setStorySet(Set<Story> storySet) {
=======
		public Set getStorySet() {
			return storySet;
		}

		public void setStorySet(Set storySet) {
>>>>>>> origin/master
			this.storySet = storySet;
		}

	}



