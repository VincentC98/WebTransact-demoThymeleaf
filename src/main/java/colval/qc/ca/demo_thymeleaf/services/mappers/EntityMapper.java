package colval.qc.ca.demo_thymeleaf.services.mappers;

public interface EntityMapper<T, D> {
    D entityToDto(T t);
}
