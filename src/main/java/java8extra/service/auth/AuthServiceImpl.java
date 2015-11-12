package java8extra.service.auth;

import javax.ejb.Stateless;

@Stateless
public class AuthServiceImpl implements AuthService {

	@Override
	public AuthResult authorization(AuthBizIn input) {
		System.out.println("username="+input.getUserName());
		if(!input.getUserName().isEmpty() && input.getUserName().equals("kaoru")){
			return new AuthResult();
		}
		return null;
	}

}
