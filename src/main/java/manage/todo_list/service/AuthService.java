package manage.todo_list.service;

import manage.todo_list.utils.dto.AuthDTO;
import manage.todo_list.utils.dto.RegisterDTO;
import manage.todo_list.utils.response.AuthResponse;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    AuthResponse login(AuthDTO req);
    AuthResponse register(RegisterDTO req);
    AuthResponse refreshToken(String refreshToken);
}
