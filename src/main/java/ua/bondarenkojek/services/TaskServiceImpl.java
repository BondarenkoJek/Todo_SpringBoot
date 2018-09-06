package ua.bondarenkojek.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.bondarenkojek.models.Task;
import ua.bondarenkojek.repository.TaskRepository;



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
}
