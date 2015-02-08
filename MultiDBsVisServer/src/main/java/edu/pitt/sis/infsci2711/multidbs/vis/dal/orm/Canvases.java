package edu.pitt.sis.infsci2711.multidbs.vis.dal.orm;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ColfusionCanvases generated by hbm2java
 */
public class Canvases implements java.io.Serializable {

private Integer vid;
private Users users;
private String name;
private String note;
private Date mdate;
private Date cdate;
private Integer privilege;

public Canvases() {
}

public Canvases(Date mdate, Date cdate) {
this.mdate = mdate;
this.cdate = cdate;
}

public Canvases(Users users, String name,
String note, Date mdate, Date cdate, Integer privilege) {
this.users = users;
this.name = name;
this.note = note;
this.mdate = mdate;
this.cdate = cdate;
this.privilege = privilege;
}

public Integer getVid() {
return this.vid;
}

public void setVid(Integer vid) {
this.vid = vid;
}

public Users getUsers() {
return this.users;
}

public void setUsers(Users users) {
this.users = users;
}

public String getName() {
return this.name;
}

public void setName(String name) {
this.name = name;
}

public String getNote() {
return this.note;
}

public void setNote(String note) {
this.note = note;
}

public Date getMdate() {
return this.mdate;
}

public void setMdate(Date mdate) {
this.mdate = mdate;
}

public Date getCdate() {
return this.cdate;
}

public void setCdate(Date cdate) {
this.cdate = cdate;
}

public Integer getPrivilege() {
return this.privilege;
}

public void setPrivilege(Integer privilege) {
this.privilege = privilege;
}

}
