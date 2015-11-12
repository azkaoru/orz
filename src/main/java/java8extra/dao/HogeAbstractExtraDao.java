package java8extra.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public abstract class HogeAbstractExtraDao<IN> implements ExtraDao<IN, ExtraEntity> {

	abstract EntityManager getEM();

	@Override
	public Optional<ExtraEntity> executeSingleFinderFunction(UseInstance<EntityManager, ExtraEntity, Exception> instance) {
		System.out.println("executeSingleFinderFunction!!!");
		ExtraEntity accept = null;
		try {
			accept = instance.apply(getEM());
		} catch (Exception e) {
			if(NoResultException.class.isInstance(e)){
				return Optional.empty();
			}
		}
		return Optional.of(accept);
	}

	@Override
	public Optional<List<ExtraEntity>> executeCollectionFinderFunction(
			UseInstance<EntityManager, List<ExtraEntity>, Exception> instance) {
		List<ExtraEntity> accept = null;
		try {
			accept = instance.apply(getEM());
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
