package com.robsan.dao;

import com.robsan.types.User;

import java.util.List;

/**
 * Created by lordofeverything on 08/02/15.
 */
public interface UserDao {

    Integer addUser(User user);

    List<User> getUser(Integer sid);
}
