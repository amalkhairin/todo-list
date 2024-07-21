package manage.todo_list.utils.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDetailDTO {
    private String taskTodo;
    private String isCompleted;
    @NotNull(message = "Task ID cannot be null")
    private Integer taskId;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
