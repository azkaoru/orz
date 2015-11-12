package java8extra.service;

import java.io.Serializable;

public interface BizOut<T> extends Serializable{

	 T get(); 
}
