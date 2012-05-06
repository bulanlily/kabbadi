package kabbadi.service;

import kabbadi.domain.db.GenericRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
public class GenericService<T> {
    protected GenericRepository<T> repository;

    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    @Transactional
    public void saveOrUpdate(T item) {
        repository.saveOrUpdate(item);
    }

    @Transactional
    public List<T> list() {
        return repository.list();
    }

    @Transactional(readOnly = true)
    public T get(Integer id) {
        return repository.get(id);
    }

}
