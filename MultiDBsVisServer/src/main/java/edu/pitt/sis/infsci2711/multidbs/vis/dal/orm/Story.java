package edu.pitt.sis.infsci2711.multidbs.vis.dal.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Story {
	
	private Integer sid;
	private Date cdate;
	private String did;
	private String dname;
	private String tname;
	private Canvases canvases;
	
	private Set<Charts> chartSet = new HashSet(0);
	
	public Story(){
		
	}
	
	public Story(Date cdate){
		this.cdate = cdate;
	}
	
	public Story(String did, String dname, String tname, Canvases canvas) {
		super();
		this.did = did;
		this.dname = dname;
		this.tname = tname;
		this.canvases = canvas;
	}
	
	public Story(Integer sid, Date cdate, String did, String dname,
			String tname, Canvases canvas, Set<Charts> chartSet) {
		super();
		this.sid = sid;
		this.cdate = cdate;
		this.did = did;
		this.dname = dname;
		this.tname = tname;
		this.canvases = canvas;
		this.chartSet = chartSet;
	}
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
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
	public Canvases getCanvases() {
		return canvases;
	}
	public void setCanvases(Canvases canvas) {
		this.canvases = canvas;
	}

	public Set<Charts> getChartSet() {
		return chartSet;
	}

	public void setChartSet(Set<Charts> chartSet) {
		this.chartSet = chartSet;
	}

}
