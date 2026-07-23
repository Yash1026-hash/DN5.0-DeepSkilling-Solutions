package com.dn5;

public interface UserRepository {

    User findById(int id);

    void save(User user);

    void deleteById(int id);

    boolean existsById(int id);
}
