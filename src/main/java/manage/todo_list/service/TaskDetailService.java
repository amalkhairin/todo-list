package manage.todo_list.service;

import manage.todo_list.model.TaskDetail;
import manage.todo_list.utils.dto.TaskDetailDTO;

public interface TaskDetailService {
    TaskDetail create(TaskDetailDTO req);
    boolean isCompleted(Integer id);
}
