package java8extra.service;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class LocalServiceOrder extends AbstractServiceOrder<OrderContext> {

	@Override
	public BeanFinderFactory getBeanFinderFactory() {
		return new LocalJndiBeanFinderFactory();
	}
	
	
	class LocalJndiBeanFinderFactory implements BeanFinderFactory  {

		@Override
		public BeanFinder get() {
			try {
				return new JndiBeanFinder(this.getContext());
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//TODO: Emptyどうやってかえすのか？
			return null;
		}
		
		public Context getContext() throws NamingException {
			// TODO Auto-generated method stub
			return new InitialContext();
		}
	}

}
