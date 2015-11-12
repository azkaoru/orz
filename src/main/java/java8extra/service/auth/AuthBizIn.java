package java8extra.service.auth;

import java8extra.service.BizIn;

public class AuthBizIn implements BizIn{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthBizIn(String userName, String passwd) {
		super();
		this.userName = userName;
		this.passwd = passwd;
	}
	

	public AuthBizIn() {
		super();
	}


	private String userName;
	
	private String passwd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	
}
