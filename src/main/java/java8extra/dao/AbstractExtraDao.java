package java8extra.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public abstract class AbstractExtraDao<IN> implements ExtraDao<IN, MessageEntity> {

	abstract EntityManager getEM();

	@Override
	public Optional<MessageEntity> executeSingleFinderFunction(
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

	@Override
	public Optional<List<MessageEntity>> executeCollectionFinderFunction(
			UseInstance<EntityManager, List<MessageEntity>, Exception> useInstance) {
		List<MessageEntity> accept = null;
		try {
			accept = useInstance.apply(getEM());
		} catch (Exception e) {
			if(NoResultException.class.isInstance(e)){
				return Optional.empty();
			}
		}
		if(accept== null){
			
		}
		return Optional.of(accept);
	}
	
}
