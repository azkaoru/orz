package java8extra.dao;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless
public class MessageExtraDao implements ExtraDao<ExtraInputModel, MessageEntity> {

	@PersistenceContext(unitName = "javax8extra-persistence-unit")
	private EntityManager em;
	
	@Override
	public Optional<MessageEntity> executeSingleFinderFunction(
			UseInstance<EntityManager, MessageEntity, Exception> useInstance) {
		System.out.println("executeSingleFinderFunction!!!");
		MessageEntity accept = null;
		try {
			accept = useInstance.apply(this.em);
		} catch (Exception e) {
			if(NoResultException.class.isInstance(e)){
				return Optional.empty();
			}
		}
		//TODO: accpetがnullの場合があるよ。
		return Optional.of(accept);
	}

	@Override
	public Optional<List<MessageEntity>> executeCollectionFinderFunction(
			UseInstance<EntityManager, List<MessageEntity>, Exception> useInstance) {
		List<MessageEntity> accept = null;
		try {
			accept = useInstance.apply(this.em);
		} catch (Exception e) {
			if(NoResultException.class.isInstance(e)){
				return Optional.empty();
			}
		}
		//TODO: accpetがnullの場合があるよ。
		return Optional.of(accept);
	}
	
	

}
