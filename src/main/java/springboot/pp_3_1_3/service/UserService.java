package springboot.pp_3_1_3.service;


import springboot.pp_3_1_3.entity.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Long id);

    void saveUser(User user);

    void updateUser(Long id, User updatedUser);

    void deleteUser(Long id);
}
