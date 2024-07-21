package manage.todo_list.service.impl;

import lombok.RequiredArgsConstructor;
import manage.todo_list.model.Task;
import manage.todo_list.model.UserEntity;
import manage.todo_list.repository.TaskRepository;
import manage.todo_list.service.TaskService;
import manage.todo_list.service.UserService;
import manage.todo_list.utils.dto.TaskDTO;
import manage.todo_list.utils.specification.TaskSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserService userService;

    @Override
    public Task create(TaskDTO req) {
        UserEntity userEntity = userService.getById(req.getUserId());
        Task task = Task.builder()
                .title(req.getTitle())
                .description(req.getDescription())
                .userEntity(userEntity)
                .build();
        return taskRepository.save(task);
    }

    @Override
    public Page<Task> getAll(Pageable pageable, String name) {
        Specification<Task> spec = TaskSpecification.getSpecification(name);
        return taskRepository.findAll(spec, pageable);
    }

    @Override
    public Task getById(Integer id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public Task update(Integer id, TaskDTO req) {
        Task task = this.getById(id);
        task.setTitle(req.getTitle());
        task.setDescription(req.getDescription());
        return taskRepository.save(task);
    }

    @Override
    public void deleteById(Integer id) {
        Task task = this.getById(id);
        taskRepository.delete(task);
    }
}
