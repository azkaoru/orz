package java8extra.service;


import java8extra.service.ServiceOrder.SERVICE_TYPE;

import javax.naming.NamingException;


public interface BeanFinder {

	
	BizService findService(SERVICE_TYPE type) throws NamingException;
	
	void close();
	

}
