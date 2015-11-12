package java8extra.service;




public abstract class AbstractServiceOrder<ORDER_CON extends OrderContext> implements ServiceOrder<BizIn> {

	
	private BizIn serviceInput;

	@Override
	public void setInput(BizIn input) {
		this.serviceInput = input;
	}

	@Override
	public BizIn getInput() {
		return this.serviceInput;
	}
	
	public abstract AbstractServiceOrderFactory<?> getFactory();
	

//	public abstract class ServiceOrderFactory<T extends BizIn> implements Supplier <ServiceOrder<BizIn>> {
//
//
//
//		protected abstract T createInstacne();
//		
//		
//		public ServiceOrder<BizIn> gen(Consumer<T> consumer){
//			T createInstacne = createInstacne();
//			consumer.accept(createInstacne);
//			ServiceOrder<BizIn> serviceOrder = this.get();
//			serviceOrder.setInput(createInstacne);
//			return serviceOrder;
//		}
//		
//	}

	
	
}
