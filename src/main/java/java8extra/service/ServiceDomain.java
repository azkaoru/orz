package java8extra.service;



public interface ServiceDomain {

	default BizOut<?> defaultSimpleExecuteInvoke(ServiceOrder<BizIn> serviceOrder) throws ServiceOrderException {
		
		System.out.println("hoge");
		System.out.println("order="+serviceOrder);
		BeanFinder beanFinder = serviceOrder.getBeanFinderFactory().get();
		System.out.println("beanfinder:"+beanFinder);
		try {
			BizService<?> bizService = beanFinder.findService(serviceOrder.getType());
			System.out.println("bizService:"+ bizService);
			return bizService.invoke(serviceOrder.getInput());
		} catch (ServiceOrderException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceOrderException("service invoke err", e);
		} finally {
			if(beanFinder!=null){
				beanFinder.close();	
			}
		}
	}
	
}
