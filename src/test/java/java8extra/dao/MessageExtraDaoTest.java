package java8extra.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import java8extra.TestUtil;
import java8extra.dao.ExtraDao;
import java8extra.dao.ExtraInputModel;
import java8extra.dao.MessageEntity;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class MessageExtraDaoTest {

	@Resource
	private UserTransaction utx;

	@PersistenceContext
	EntityManager em;

	@EJB
	ExtraDao<ExtraInputModel, MessageEntity> messageExtraDao;

	@Deployment(name = "java8extra", managed = true)
	public static Archive<?> createTestArchive() {
		return TestUtil.archiveDeploymentForDBclean();
	}

	@Before
	public void before() throws NotSupportedException, SystemException, SecurityException, IllegalStateException,
			RollbackException, HeuristicMixedException, HeuristicRollbackException {
		utx.begin();
		MessageEntity entity = new MessageEntity();
		entity.setValue("foo");
		entity.setReservedDate(new Date());

		this.em.persist(entity);

		MessageEntity entity2 = new MessageEntity();
		entity2.setValue("bar");
		entity2.setReservedDate(new Date());

		this.em.persist(entity2);

		utx.commit();
	}

	@Test
	public void testExtra() {
		Optional<List<MessageEntity>> messages = 
				messageExtraDao.executeCollectionFinderFunction(emInsstance ->
				                                                emInsstance.createNamedQuery("findMessageAll", MessageEntity.class).getResultList());

		assertEquals(2, messages.get().size());

	}

}
