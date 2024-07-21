package manage.todo_list.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import manage.todo_list.service.TaskService;
import manage.todo_list.utils.dto.TaskDTO;
import manage.todo_list.utils.response.PageResponse;
import manage.todo_list.utils.response.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @PostMapping
    @Validated
    public ResponseEntity<?> create(@Valid @RequestBody TaskDTO request) {
        return Response.renderJSON(
                taskService.create(request),
                "Success",
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(required = false) String name
    ) {
        return Response.renderJSON(new PageResponse<>(taskService.getAll(pageable, name)), "Success", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        return Response.renderJSON(taskService.getById(id));
    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody TaskDTO request) {
        return Response.renderJSON(taskService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
