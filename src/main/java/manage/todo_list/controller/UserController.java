package manage.todo_list.controller;

import ch.qos.logback.classic.Logger;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import manage.todo_list.service.UserService;
import manage.todo_list.utils.dto.UserDTO;
import manage.todo_list.utils.response.PageResponse;
import manage.todo_list.utils.response.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    @Validated
    public ResponseEntity<?> create(@Valid @RequestBody UserDTO request) {
        return Response.renderJSON(
                userService.create(request),
                "Success",
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAll(
            @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(required = false) String name
    ) {
        return Response.renderJSON(
                new PageResponse<>(userService.getAll(pageable, name)), "Success", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Integer id) {
        return Response.renderJSON(
                userService.getById(id),
                "Success",
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    @Validated
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody UserDTO request) {
        return Response.renderJSON(
                userService.update(id, request),
                "Success",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
