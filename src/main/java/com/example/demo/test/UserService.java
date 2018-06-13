package com.example.demo.test;

import java.util.List;

/**
 * Created by lu on 2018/6/3.
 */
public interface UserService {

    List<User> list();

    User findUserById(Long id);

    User findInfoById(Long id);

    void update(User user);

    void remove(Long id);

    User upuser(Long id);

}

