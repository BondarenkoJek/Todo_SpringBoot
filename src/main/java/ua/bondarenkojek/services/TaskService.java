package ua.bondarenkojek.services;


import ua.bondarenkojek.models.Task;


public interface TaskService {
    Task findById(Long id);
    void deleteById(Long id);
    void save(Task task);
}
