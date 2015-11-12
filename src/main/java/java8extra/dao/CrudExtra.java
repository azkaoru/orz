package java8extra.dao;

import java.util.function.Consumer;

import javax.persistence.EntityManager;


public abstract class CrudExtra<IN,R extends ExtraEntity> implements ExtraDao2<IN, R> {

	abstract EntityManager getEM();
	
	public void insert(IN inputModel,Consumer<IN> fun) {
		fun.accept(inputModel);
		this.getEM().persist(inputModel);
	}

	public void update(IN inputModel) {
		this.getEM().merge(inputModel);
		
	}

	public void delete(IN inputModel) {
		this.getEM();
		
	}
	

	
	


	
	
	
}
