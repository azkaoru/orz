package java8extra.service;



public abstract class AbstractServiceWrapper<SERVICE,SERVICE_IN,SERVICE_OUT> implements BizService<SERVICE_OUT> {
	
	public abstract SERVICE getService();
	
	public abstract SERVICE_IN castInput(BizIn input) throws ServiceOrderException;

	
	public abstract SERVICE_OUT serviceExecute(SERVICE_IN input);
	
	@Override
	public BizOut<SERVICE_OUT> invoke(BizIn input) throws ServiceOrderException {
		SERVICE_IN castInput = this.castInput(input);
		
		SERVICE_OUT serviceExecute = this.serviceExecute(castInput);
		if(serviceExecute == null){
			throw new ServiceOrderException(new IllegalArgumentException("serivce result is null"));
		}
		return ()-> serviceExecute;
	}
	
	public  <T> T castInput(Class<T> classType ,BizIn bizIn) throws ServiceOrderException{
		if(classType.isInstance(bizIn)){
			return (T) bizIn;
		}
		throw new ServiceOrderException(new IllegalArgumentException("serivce invalid argment type,classtype=")+classType.getTypeName());
	}

	
}
