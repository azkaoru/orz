package java8extra.service.impl;

import java8extra.service.BizIn;
import java8extra.service.BizOut;
import java8extra.service.ServiceDomain;
import java8extra.service.ServiceOrder;
import java8extra.service.ServiceOrderException;

import javax.ejb.Stateless;

@Stateless
public class ServiceDomainImpl implements ServiceDomain {

	@Override
	public BizOut<?> defaultSimpleExecuteInvoke(ServiceOrder<BizIn> serviceOrder)
			throws ServiceOrderException {
		return ServiceDomain.super.defaultSimpleExecuteInvoke(serviceOrder);
	}

	
}
