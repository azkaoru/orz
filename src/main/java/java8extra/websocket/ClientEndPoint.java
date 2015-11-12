package java8extra.websocket;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class ClientEndPoint {

	@OnOpen
	public void onOpen(Session session){
		try {
			session.getBasicRemote().sendText("hello world");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@OnMessage
	public void onMessage(String message){
		System.out.println("client receive message="+message);
	}
	
	
}
