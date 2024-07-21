package manage.todo_list.service;

import manage.todo_list.model.UserEntity;
import manage.todo_list.utils.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserEntity create(UserDTO req);
    UserEntity update(Integer id, UserDTO req);
    Page<UserEntity> getAll(Pageable pageable, String name);
    UserEntity getById(Integer id);
    UserEntity getByUsername(String username);
    UserEntity getByEmail(String email);
    void deleteById(Integer id);

}
