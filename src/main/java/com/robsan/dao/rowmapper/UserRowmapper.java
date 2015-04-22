package com.robsan.dao.rowmapper;

import com.robsan.types.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by lordofeverything on 08/02/15.
 */
@Component
public class UserRowmapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        Date deregDate = (rs.getDate("DEREG_DATE") == null) ? null : new Date(rs.getDate("DEREG_DATE").getTime());

        User user = new User(rs.getString("FIRSTNAME"),
                rs.getString("LASTNAME"),
                rs.getString("EMAIL"),
                rs.getString("USERNAME"),
                rs.getString("USERPWD"),
                rs.getInt("CSTNO"),
                new Date(rs.getDate("CREATE_TIME").getTime()),
                new Date(rs.getDate("TSTAMP").getTime()),
                deregDate,
                rs.getString("COUNTRY"),
                rs.getInt("STATUS"),
                rs.getString("STATUS_TEXT"),
                rs.getString("USER_REF")
                );

        return user;
    }


}
