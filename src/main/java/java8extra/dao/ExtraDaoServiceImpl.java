package java8extra.dao;

import java.util.List;
import java.util.Optional;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ExtraDaoServiceImpl extends AbstractExtraDao<ExtraInputModel> {

	
	@Inject
	private Event<String> event;
	
	@PersistenceContext(unitName = "javax8extra-persistence-unit")
	private EntityManager em;
	

	@Asynchronous
	void asyncInvoke(ExtraInputModel input) {
		String message = input.getMessage();
		
		event.fire(message);
		//TODO: inputからメッセージリストを取得して、以下の処理を繰り返す
		// *insert,observerに通知
		// observerは通知を受信をすると、websocketでメッセージ内容をひとつずつ送信する.(クライアントに返す)
		
	}

	@Override
	EntityManager getEM() {
		return this.em;
	}
	
	
	public Optional<List<MessageEntity>> findAll(){
		return this.executeCollectionFinderFunction(emInsstance ->
        emInsstance.createNamedQuery("findMessageAll", MessageEntity.class).getResultList());
	}
	
	




}
