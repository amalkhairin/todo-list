package manage.todo_list.service;

import manage.todo_list.model.Task;
import manage.todo_list.utils.dto.TaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    Task create(TaskDTO req);
    Page<Task> getAll(Pageable pageable, String name);
    Task getById(Integer id);
    Task update(Integer id, TaskDTO req);
    void deleteById(Integer id);
}
