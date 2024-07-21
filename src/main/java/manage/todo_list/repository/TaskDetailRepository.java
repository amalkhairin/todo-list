package manage.todo_list.repository;

import manage.todo_list.model.TaskDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDetailRepository extends JpaRepository<TaskDetail, Integer> {
}
