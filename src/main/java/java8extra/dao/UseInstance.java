package java8extra.dao;

@FunctionalInterface
public interface UseInstance <T,R,X extends Throwable>{
	
	R apply(T instance) throws X;
}
