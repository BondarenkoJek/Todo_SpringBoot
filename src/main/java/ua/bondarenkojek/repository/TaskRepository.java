package ua.bondarenkojek.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ua.bondarenkojek.models.Task;



import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUser_Id(Long userId, Pageable pageable);
}
