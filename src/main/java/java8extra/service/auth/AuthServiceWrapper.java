package java8extra.service.auth;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import java8extra.service.AbstractServiceWrapper;
import java8extra.service.BizIn;
import java8extra.service.BizOut;
import java8extra.service.BizService;
import java8extra.service.ServiceOrderException;

@Stateless
@Remote(BizService.class)
public class AuthServiceWrapper extends
		AbstractServiceWrapper<AuthService, AuthBizIn, AuthResult> {

	@EJB
	AuthService authService;
	
	@Override
	public AuthService getService() {
		// TODO Auto-generated method stub
		return this.authService;
	}

	@Override
	public AuthBizIn castInput(BizIn input) throws ServiceOrderException {
		return this.castInput(AuthBizIn.class, input);
	}

	@Override
	public AuthResult serviceExecute(AuthBizIn input) {
		return getService().authorization(input);
	}
	

}
