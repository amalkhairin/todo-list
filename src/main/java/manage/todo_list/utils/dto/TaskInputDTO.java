package manage.todo_list.utils.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import manage.todo_list.model.TaskDetail;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskInputDTO {
    @NotNull(message = "UserEntity ID cannot be null")
    private Integer taskId;
    private List<String> tasks;
}
