package java8extra.service;

public interface Service<IN,OUT> {
	
	OUT invoke(IN input) throws ServiceOrderException;
}
