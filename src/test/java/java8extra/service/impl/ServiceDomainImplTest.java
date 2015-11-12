package java8extra.service.impl;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import java8extra.TestUtil;
import java8extra.service.BizIn;
import java8extra.service.BizOut;
import java8extra.service.ServiceDomain;
import java8extra.service.ServiceOrder;
import java8extra.service.ServiceOrderException;
import java8extra.service.auth.AuthResult;
import java8extra.service.auth.AuthServcieOrder;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class ServiceDomainImplTest {

	@EJB ServiceDomain serviceDomain;
	
	@Deployment(name = "java8extra", managed = true)
	public static Archive<?> createTestArchive() {
		return TestUtil.archiveDeploymentForDBclean();
	}
	
	@Test
	public void testDefaultSimpleExecuteInvoke() {
		ServiceOrder<BizIn> input = new AuthServcieOrder().getFactory().gen(
				(bizIn) -> {
					bizIn.setUserName("kaoru");
				}
			);
		try {
			BizOut<AuthResult> defaultSimpleExecuteInvoke =  (BizOut<AuthResult>) serviceDomain.defaultSimpleExecuteInvoke(input);
			AuthResult authResult = defaultSimpleExecuteInvoke.get();
			assertNotNull("authResult is null", authResult);
		} catch (ServiceOrderException e) {
			// TODO Auto-generated catch block
			fail("ServiceOrderException err");
			e.printStackTrace();
		}

	}

}
