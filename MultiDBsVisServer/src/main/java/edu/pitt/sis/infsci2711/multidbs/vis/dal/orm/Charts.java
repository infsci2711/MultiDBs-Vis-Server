package edu.pitt.sis.infsci2711.multidbs.vis.dal.orm;

import java.util.HashSet;
import java.util.Set;

	public class Charts implements java.io.Serializable {

		private Integer cid;
		private Story story;
		private String name;
		private String type;
		private String did;
		private String dname;
		private String tname;
		private String columns;
		
		
		public Charts() {
			
		}
		
		public Charts(String type, String did, String dname, String tname, String columns, Story story){
			this.type = type;
			this.did = did;
			this.dname = dname;
			this.tname = tname;
			this.columns = columns;
			this.story = story;
		}
		
		public Charts(Integer cid, Story story, String name, String type,
				String did, String dname, String tname, String columns) {
			super();
			this.cid = cid;
			this.story = story;
			this.name = name;
			this.type = type;
			this.did = did;
			this.dname = dname;
			this.tname = tname;
			this.columns = columns;
		}

		
		public Integer getCid() {
			return cid;
		}
		public void setCid(Integer cid) {
			this.cid = cid;
		}
		public Story getStory() {
			return story;
		}
		public void setStory(Story story) {
			this.story = story;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getDid() {
			return did;
		}
		public void setDid(String did) {
			this.did = did;
		}
		public String getDname() {
			return dname;
		}
		public void setDname(String dname) {
			this.dname = dname;
		}
		public String getTname() {
			return tname;
		}
		public void setTname(String tname) {
			this.tname = tname;
		}
		public String getColumns() {
			return columns;
		}
		public void setColumns(String columns) {
			this.columns = columns;
		}
	
	}



