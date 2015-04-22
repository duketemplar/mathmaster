#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao.daoImpl;

import ${package}.dao.UserDao;
import ${package}.dao.sp.AddUserSP;
import ${package}.dao.sp.GetUserSP;
import ${package}.types.User;
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
