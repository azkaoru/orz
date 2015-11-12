package java8extra.service;



public interface WildflyRemoteOrderContext extends OrderContext {

	static final String DEFAULT_USERNAME = "kaoru";

	static final String DEFAULT_PASSWORD = "0822kaoru1!";

	static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";

	static final String WILDFLY_PROVIDER_URL = "http-remoting://localhost:8080";
	
	static final String URL_PKG_PREFIXES ="org.jboss.ejb.client.naming";
	
	static final String WILDFLY_EJB_CONTEXT = "";
	
	
}
