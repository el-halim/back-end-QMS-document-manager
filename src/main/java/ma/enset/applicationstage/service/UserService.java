package ma.enset.applicationstage.service;

import ma.enset.applicationstage.dao.UserRepository;
import ma.enset.applicationstage.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Transactional
public class UserService implements IUserInitService{

    @Autowired
    private UserRepository userRepository;

    public  User updateUser(User user) {
    return userRepository.save(user);
    }

    public  void deleteUser(Long id) {
        userRepository.deleteUserById(id);

    }



    public Optional<User> getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public boolean existeByUsername(String username){
        return userRepository.existsByUsername(username);
    }

    public boolean existeByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public List<User> findAllUser(){
        return userRepository.findAll();
    }

    public User addUser(User user){
//        user.setUserCode(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    public List<User> findUsersByProcessusId(Long id) {
        return userRepository.findAllByProcessusId(id);
    }
}
