package ua.bondarenkojek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.bondarenkojek.models.Task;

import java.util.List;



public interface TaskRepository extends JpaRepository<Task, Long> {
}
