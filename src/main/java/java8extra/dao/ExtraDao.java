package java8extra.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

public interface ExtraDao<IN,R> {

	Optional<R> executeSingleFinderFunction(UseInstance<EntityManager,R, Exception> instance);
	
	Optional<List<R>> executeCollectionFinderFunction(UseInstance<EntityManager,List<R>, Exception> instance);
}
