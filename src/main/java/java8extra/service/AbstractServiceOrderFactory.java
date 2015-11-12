package java8extra.service;

import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class AbstractServiceOrderFactory<T extends BizIn> implements Supplier <ServiceOrder<BizIn>> {

	public abstract Supplier<T> createInstacne();
	
	
	public ServiceOrder<BizIn> gen(Consumer<T> consumer){
		T createInstacne = createInstacne().get();
		consumer.accept(createInstacne);
		ServiceOrder<BizIn> serviceOrder = this.get();
		serviceOrder.setInput(createInstacne);
		return serviceOrder;
	}
	
}
