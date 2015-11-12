package java8extra.service;

import java8extra.service.ServiceOrder.SERVICE_TYPE;

import javax.naming.Context;
import javax.naming.NamingException;

public class JndiBeanFinder implements BeanFinder {

	
	private Context context;

	public JndiBeanFinder(Context context) {
		super();
		this.context = context;
	}


	@Override
	public BizService findService(SERVICE_TYPE type) throws NamingException {
		System.out.println("findSerivce Type:"+type.getJndiName());
		return (BizService) this.context.lookup(type.getJndiName());
	}
	
	@Override
	public void close() {
		try {
			context.close();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
