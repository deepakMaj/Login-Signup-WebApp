package org.deepak.login;

public class LoginData {
		private String username;
		private String password;
		private String email;
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public LoginData(String username, String password, String email) {
			super();
			this.username = username;
			this.password = password;
			this.email = email;
		}
		public LoginData(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
}
