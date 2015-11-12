package java8extra.websocket;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.jboss.logging.Logger;

@ServerEndpoint(value="/messages")
public class MessageEndPoint {
	
	private static final Logger LOGGER = Logger.getLogger(MessageEndPoint.class);

	public MessageEndPoint() {
		super();
	}
	
	@PostConstruct
	public void init(){
		
	}
	

	@OnMessage
	public String recieve(String message){
		LOGGER.info("Websocket onMessage called");
		String returnMessage = "Websocket onMessage called by "+this.getClass() + ", message= "+ message;
		return "Recieve Message On Wildfly ApServer,"+ returnMessage;
	}
	
	@OnOpen
	public void open(Session session){
		LOGGER.info("OnOpen called by sessionid="+session.getId());
	}
	
	@OnClose
	public void close(CloseReason closeReason){
		LOGGER.info("OnClose called by closeReason="+closeReason.getCloseCode());
	}
	
	
}
