package mine.construct;

public interface BeanFactory<T> {
	T getObject() throws Exception;

	Class<?> getObjectType();
	
}
