#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import ${package}.types.User;

import java.util.List;

/**
 * Created by lordofeverything on 08/02/15.
 */
public interface UserDao {

    Integer addUser(User user);

    List<User> getUser(Integer sid);
}
