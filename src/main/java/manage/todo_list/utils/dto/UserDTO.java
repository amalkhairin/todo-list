package manage.todo_list.utils.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserDTO {
    private Integer id;
    @NotBlank(message = "Name must not be blank")
    private String name;
    @NotBlank(message = "Username must not be blank")
    private String username;
    @NotBlank(message = "Email must not be blank")
    private String email;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
