package edu.pitt.sis.infsci2711.multidbs.vis.dal.orm;

import java.util.Date;

public class Users {

		private Integer userId;
		private Date userModification;
		private Date userDate;
		private Date userLastlogin;
		private String userEmail;
		private String userNames;
	

		public Users() {
		}

		public Users(Date userModification, Date userDate,
				Date userLastlogin) {
			this.userModification = userModification;
			this.userDate = userDate;
			this.userLastlogin = userLastlogin;
		}

		public Users(Date userModification, Date userDate,
				String userEmail, String userNames, Date userLastlogin) {
			this.userModification = userModification;
			this.userDate = userDate;
			this.userEmail = userEmail;
			this.userNames = userNames;
			this.userLastlogin = userLastlogin;
		}

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

}
