package framework.converter;

public interface Converter {
    <T> T convert(Class<T> entityClass, Object value);
}
