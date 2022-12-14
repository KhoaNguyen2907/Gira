package cybersoft.javabackend.java18.gira.common.service;

import cybersoft.javabackend.java18.gira.common.model.BaseEntity;
import cybersoft.javabackend.java18.gira.common.util.GiraMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface IGenericService<T extends BaseEntity, D, I> {
    JpaRepository<T, I> getRepository();

    GiraMapper getMapper();

    default D mapToDto(T entity, Class<D> dClass) {
        return getMapper().map(entity, dClass);
    }

    default T mapToEntity(D dto, Class<T> tClass) {
        return getMapper().map(dto, tClass);
    }

    default List<T> findAll() {
        return getRepository().findAll();
    }

    default List<T> findAll(Pageable page) {
        return getRepository().findAll(page).stream().collect(Collectors.toList());
    }

    default List<D> findAllDto(Class<D> clazz) {
        return getRepository().findAll().stream()
                .map(model -> mapToDto(model, clazz))
                .collect(Collectors.toList());
    }

    default List<D> findAllDto(Pageable page, Class<D> clazz) {
        return getRepository().findAll(page).stream()
                .map(model -> mapToDto(model, clazz))
                .collect(Collectors.toList());
    }


    default Optional<T> findById(I id) {
        return getRepository().findById(id);
    }

    default T save(T entity) {
        return getRepository().save(entity);

    }

    default void deleteById(I id) {
        getRepository().deleteById(id);
    }

    default List<T> findAllByIds(List<I> ids) {
        return getRepository().findAllById(ids);
    }
}

