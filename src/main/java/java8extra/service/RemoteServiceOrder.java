
package java8extra.service;

import java.io.Serializable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public abstract class RemoteServiceOrder extends AbstractServiceOrder<WildflyRemoteOrderContext> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public BeanFinderFactory getBeanFinderFactory() {
		return new RemoteJndiBeanFinderFactory();
	}
	
	class RemoteJndiBeanFinderFactory implements BeanFinderFactory  {

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
			final Properties env = new Properties();
	        env.put(Context.INITIAL_CONTEXT_FACTORY, WildflyRemoteOrderContext.INITIAL_CONTEXT_FACTORY);
	        env.put(Context.PROVIDER_URL, WildflyRemoteOrderContext.WILDFLY_PROVIDER_URL);
	        env.put(Context.SECURITY_PRINCIPAL,WildflyRemoteOrderContext.DEFAULT_USERNAME);
	        env.put(Context.SECURITY_CREDENTIALS, WildflyRemoteOrderContext.DEFAULT_PASSWORD);
	    	env.put(Context.URL_PKG_PREFIXES, WildflyRemoteOrderContext.URL_PKG_PREFIXES);
//	    	env.put(WildflyRemoteOrderContext.WILDFLY_EJB_CONTEXT ,true);
			return new InitialContext(env);
		}
	}
	
	

}
