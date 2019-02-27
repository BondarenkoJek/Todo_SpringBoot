package ua.bondarenkojek.services;

import org.springframework.data.domain.Pageable;
import ua.bondarenkojek.models.Task;

import java.util.List;

public interface TaskService {
    Task findById(Long id);

    void deleteById(Long id);

    void save(Task task);

    List<Task> findAllByUserId(Long userId, Pageable pageable);
}
