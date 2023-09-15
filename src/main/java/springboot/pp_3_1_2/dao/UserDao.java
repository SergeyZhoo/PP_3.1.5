package springboot.pp_3_1_2.dao;



import springboot.pp_3_1_2.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUser(Long id);

    void saveUser(User user);

    void deleteUser(Long id);

    void updateUser(Long id, User updatedUser);
}
