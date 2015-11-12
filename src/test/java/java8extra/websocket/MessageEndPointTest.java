package java8extra.websocket;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java8extra.TestUtil;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ws.WebSocket;
import com.ning.http.client.ws.WebSocketTextListener;
import com.ning.http.client.ws.WebSocketUpgradeHandler;

@RunWith(Arquillian.class)
public class MessageEndPointTest {

	private static final String ENDPOINT_URL = "ws://localhost:8080/java8extra-0.1-SNAPSHOT/messages";

	@Deployment(testable = false)
	public static Archive<?> createTestArchive() {
		return TestUtil.archiveDeploymentForDBupdate();
	}

	@RunAsClient
	@Test
	public void testWebSocketExtra() throws Exception {

		final CountDownLatch latch = new CountDownLatch(1);
		AsyncHttpClient c = new AsyncHttpClient();

		WebSocket websocket = null;
		websocket = c
				.prepareGet(ENDPOINT_URL)
				.execute(
						new com.ning.http.client.ws.WebSocketUpgradeHandler.Builder().addWebSocketListener(
								new WebSocketTextListener() {

									@Override
									public void onMessage(String message) {
//										System.out.println("cecive msg="+message);
										assertThat(message, is("Recieve Message On Wildfly ApServer,Websocket onMessage called by class java8extra.websocket.MessageEndPoint, message= hogehoge"));
										latch.countDown();
									}

									@Override
									public void onOpen(WebSocket websocket) {
										System.out.println("onOpen");

									}

									@Override
									public void onClose(WebSocket websocket) {
									}

									@Override
									public void onError(Throwable t) {
									}

								}).build()).get();

		Thread.sleep(1000 * 3);
		websocket.sendMessage("hogehoge");
		try {
			assertThat(latch.await(5, TimeUnit.SECONDS), is(true));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.close();
	}

	@RunAsClient
	@Test
	public void test2() throws InterruptedException, ExecutionException {
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		WebSocketUpgradeHandler handler = new WebSocketUpgradeHandler.Builder().build();
		WebSocket webSocket = asyncHttpClient.prepareGet(ENDPOINT_URL).execute(handler).get();
		assertNotNull(webSocket);
		
	}
	
	public static void main(String[] args) {
		
		final CountDownLatch latch=new CountDownLatch(1);
		AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
		WebSocketUpgradeHandler handler = new WebSocketUpgradeHandler.Builder().build();
		WebSocket webSocket = null;
		try {
			webSocket = asyncHttpClient.prepareGet(ENDPOINT_URL).execute(handler).get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(webSocket!= null){
			webSocket.isOpen();
		}
		System.out.println(webSocket);
		final AtomicReference<String> receivedEvent=new AtomicReference<String>();
		
		 webSocket.addWebSocketListener(new WebSocketTextListener() {
			
			@Override
			public void onOpen(WebSocket websocket) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClose(WebSocket websocket) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onMessage(String message) {
				  System.out.println("client recieve message:"+message);
				  receivedEvent.set(message);
			      latch.countDown();
				
			}
		});
		 
		 webSocket.sendMessage("hellow world");
		 try {
			latch.await(2,TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 String string = receivedEvent.get();
		 System.out.println("final confirm:"+string);
		 
	}

}
