package com.dn5;

public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int id) {
        User user = userRepository.findById(id);
        if (user == null) {
            throw new RuntimeException("User not found with id: " + id);
        }
        return user;
    }

    public void createUser(User user) {
        if (userRepository.existsById(user.getId())) {
            throw new RuntimeException("User already exists with id: " + user.getId());
        }
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
