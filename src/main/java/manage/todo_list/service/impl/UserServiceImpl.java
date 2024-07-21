package manage.todo_list.service.impl;

import lombok.RequiredArgsConstructor;
import manage.todo_list.model.UserEntity;
import manage.todo_list.repository.UserRepository;
import manage.todo_list.service.UserService;
import manage.todo_list.utils.dto.UserDTO;
import manage.todo_list.utils.specification.UserSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserEntity create(UserDTO req) {
        UserEntity userEntity = UserEntity.builder()
                .name(req.getName())
                .username(req.getUsername())
                .email(req.getEmail())
                .build();
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity update(Integer id, UserDTO req) {
        UserEntity userEntity = this.getById(id);
        userEntity.setName(req.getName());
        userEntity.setUsername(req.getUsername());
        userEntity.setEmail(req.getEmail());

        return userRepository.save(userEntity);
    }

    @Override
    public Page<UserEntity> getAll(Pageable pageable, String name) {
        Specification<UserEntity> spec = UserSpecification.getSpecification(name);
        return userRepository.findAll(spec, pageable);
    }

    @Override
    public UserEntity getById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("UserEntity not found"));
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("UserEntity not found"));
    }

    @Override
    public UserEntity getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("UserEntity not found"));
    }

    @Override
    public void deleteById(Integer id) {
        UserEntity userEntity = this.getById(id);
        userRepository.delete(userEntity);
    }
}
