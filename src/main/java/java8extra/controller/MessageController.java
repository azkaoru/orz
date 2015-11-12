package java8extra.controller;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;

@RequestScoped
public class MessageController {

	
	void receive(@Observes String meesage) {
		
	}
}
