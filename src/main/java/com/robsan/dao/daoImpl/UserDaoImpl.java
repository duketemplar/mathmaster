package com.robsan.dao.daoImpl;

import com.robsan.dao.UserDao;
import com.robsan.dao.sp.AddUserSP;
import com.robsan.dao.sp.GetUserSP;
import com.robsan.types.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lordofeverything on 08/02/15.
 */
@Component
public class UserDaoImpl implements UserDao{

    @Autowired
    AddUserSP addUserSP;

    @Autowired
    GetUserSP getUserSP;


    public Integer addUser(User user){
        return addUserSP.execute(user);
    }
    public List<User> getUser(Integer sid){
        return getUserSP.execute(sid);
    }
}
