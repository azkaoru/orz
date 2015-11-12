package java8extra.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public abstract class AbstractExtraDao2<IN> implements ExtraDao2<IN, MessageEntity> {

	abstract EntityManager getEM();

	@Override
	public Optional<ExtraEntity> executeSingleFinderFunction(
			UseInstance<EntityManager, MessageEntity, Exception> useInstance) {
		System.out.println("executeSingleFinderFunction!!!");
		MessageEntity accept = null;
		try {
			accept = useInstance.apply(getEM());
		} catch (Exception e) {
			if(NoResultException.class.isInstance(e)){
				return Optional.empty();
			}
		}
		return Optional.of(accept);
	}

	
}
