package ua.bondarenkojek.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.bondarenkojek.models.Task;
import ua.bondarenkojek.repository.TaskRepository;
import ua.bondarenkojek.services.TaskService;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).get();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public List<Task> findAllByUserId(Long userId, Pageable pageable) {
        return taskRepository.findAllByUser_Id(userId, pageable);
    }
}
