package java8extra.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

public interface ExtraDao2<IN,R extends ExtraEntity> {

	
	Optional<ExtraEntity> executeSingleFinderFunction(UseInstance<EntityManager,R, Exception> instance);
	
//	Optional<List<ExtraEntity>> executeCollectionFinderFunction(UseInstance<EntityManager,List<R>, Exception> instance);
	
	
	
}
