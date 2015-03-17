package edu.pitt.sis.infsci2711.multidbs.vis.dal.viewmodels;

import java.util.Date;
<<<<<<< HEAD
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import edu.pitt.sis.infsci2711.multidbs.vis.dal.orm.Story;

=======

import javax.xml.bind.annotation.XmlRootElement;

>>>>>>> origin/master
@XmlRootElement
public class UserViewModel {
	private Integer userId;
	private Date userModification;
	private Date userDate;
	private Date userLastlogin;
	private String userEmail;
	private String userNames;
<<<<<<< HEAD
	
	private Set<StoryViewModel> stories = new HashSet<StoryViewModel>();
	

	public UserViewModel() {
		
=======


	public UserViewModel() {
>>>>>>> origin/master
	}

	public UserViewModel(Date userModification, Date userDate,
			Date userLastlogin) {
		this.userModification = userModification;
		this.userDate = userDate;
		this.userLastlogin = userLastlogin;
	}

<<<<<<< HEAD
	public UserViewModel(int userId, Date userModification, Date userDate,
=======
	public UserViewModel(Integer userId, Date userModification, Date userDate,
>>>>>>> origin/master
			String userEmail, String userNames, Date userLastlogin) {
		this.userId = userId;
		this.userModification = userModification;
		this.userDate = userDate;
<<<<<<< HEAD
		this.userEmail = userEmail != null ? userEmail : "";
		this.userNames = userNames;
		this.userLastlogin = userLastlogin;
	}
	
	public UserViewModel(int userId, String userNames) {
		this.userId = userId;
		this.userNames = userNames;
	}
	
=======
		this.userEmail = userEmail;
		this.userNames = userNames;
		this.userLastlogin = userLastlogin;
	}
>>>>>>> origin/master

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getUserModification() {
		return this.userModification;
	}

	public void setUserModification(Date userModification) {
		this.userModification = userModification;
	}

	public Date getUserDate() {
		return this.userDate;
	}

	public void setUserDate(Date userDate) {
		this.userDate = userDate;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNames() {
		return this.userNames;
	}

	public void setUserNames(String userNames) {
		this.userNames = userNames;
	}

	public Date getUserLastlogin() {
		return this.userLastlogin;
	}

	public void setUserLastlogin(Date userLastlogin) {
		this.userLastlogin = userLastlogin;
	}

<<<<<<< HEAD
	public Set<StoryViewModel> getStories() {
		return stories;
	}

	public void setStories(Set<StoryViewModel> stories) {
		this.stories = stories;
	}


=======
>>>>>>> origin/master
}
