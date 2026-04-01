package vcube.Model;
public class LoginModel {
	private String userName;
	private String password;
	public LoginModel() {
		
	}
	public LoginModel(String un,String pwd) {
		this.userName=un;
		this.password=pwd;
		
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginModel [userName=" + userName + "]";
	}
	

}
