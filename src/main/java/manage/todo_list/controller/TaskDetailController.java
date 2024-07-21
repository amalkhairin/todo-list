package manage.todo_list.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import manage.todo_list.service.TaskDetailService;
import manage.todo_list.utils.dto.TaskDetailDTO;
import manage.todo_list.utils.response.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/task-todos")
@RequiredArgsConstructor
public class TaskDetailController {
    private final TaskDetailService taskDetailService;

    @PostMapping
    @Validated
    public ResponseEntity<?> create(@Valid @RequestBody TaskDetailDTO request) {
        return Response.renderJSON(
                taskDetailService.create(request),
                "Success",
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}/is-completed")
    public ResponseEntity<?> update(@PathVariable("id") Integer id) {
        return Response.renderJSON(
                taskDetailService.isCompleted(id),
                "Success",
                HttpStatus.OK
        );
    }
}
