package manage.todo_list.service.impl;

import lombok.RequiredArgsConstructor;
import manage.todo_list.model.Task;
import manage.todo_list.model.TaskDetail;
import manage.todo_list.model.UserEntity;
import manage.todo_list.repository.TaskDetailRepository;
import manage.todo_list.service.TaskDetailService;
import manage.todo_list.service.TaskService;
import manage.todo_list.utils.dto.TaskDetailDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskDetailServiceImpl implements TaskDetailService {
    private final TaskDetailRepository taskDetailRepository;
    private final TaskService taskService;

    @Override
    public TaskDetail create(TaskDetailDTO req) {
        TaskDetail taskDetail = TaskDetail.builder()
                .taskTodo(req.getTaskTodo())
                .task(taskService.getById(req.getTaskId()))
                .isCompleted(false)
                .build();
        return taskDetailRepository.save(taskDetail);
    }

    @Override
    public boolean isCompleted(Integer id) {
        TaskDetail taskDetail = taskDetailRepository.findById(id).orElseThrow(() -> new RuntimeException("TaskDetail not found"));
        taskDetail.setIsCompleted(!taskDetail.getIsCompleted());
        taskDetailRepository.save(taskDetail);
        return true;
    }
}
