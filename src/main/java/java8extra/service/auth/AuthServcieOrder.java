package java8extra.service.auth;

import java.util.function.Supplier;

import java8extra.service.AbstractServiceOrderFactory;
import java8extra.service.BizIn;
import java8extra.service.RemoteServiceOrder;
import java8extra.service.ServiceOrder;


public class AuthServcieOrder extends RemoteServiceOrder {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public SERVICE_TYPE getType() {
		return SERVICE_TYPE.AUTH;
	}

	@Override
	public AbstractServiceOrderFactory<AuthBizIn> getFactory() {
		return new AuthServiceOrderFactory();
	}

	
	class AuthServiceOrderFactory extends AbstractServiceOrderFactory<AuthBizIn>{

		private AuthServiceOrderFactory() {
			super();
		}

		@Override
		public ServiceOrder<BizIn> get() {
			return new AuthServcieOrder();
		}

		@Override
		public Supplier<AuthBizIn> createInstacne() {
			return AuthBizIn::new;
		}
		
	}






	



	
}
