package com.robsan.dao.sp;

import com.robsan.types.User;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by lordofeverything on 08/02/15.
 */
@Component
public class AddUserSP extends StoredProcedure {


    final static Logger LOGGER = Logger.getLogger(AddUserSP.class);

    public static final String SP_ADD_USER = "PKG_MATHMASTER.sp_add_user";
    public static final String I_FIRSTNAME = "i_firstname";
    public static final String I_LASTNAME = "i_lastname";
    public static final String I_EMAIL = "i_email";
    public static final String I_USERNAME = "i_username";
    public static final String I_PASSWORD = "i_userpwd";
    public static final String I_CSTNO = "i_cstno";
    public static final String I_COUNTRY = "i_country";
    public static final String I_REF = "i_user_ref";
    public static final String O_SID = "o_sid";

    public static final Integer FAILED = 0;


    @Autowired
    public AddUserSP(@Qualifier("oracleJdbcTemplate") JdbcTemplate jdbcTemplate) {

        super(jdbcTemplate, SP_ADD_USER);

        declareParameter(new SqlParameter(I_FIRSTNAME, Types.VARCHAR));
        declareParameter(new SqlParameter(I_LASTNAME, Types.VARCHAR));
        declareParameter(new SqlParameter(I_EMAIL, Types.VARCHAR));
        declareParameter(new SqlParameter(I_USERNAME, Types.VARCHAR));
        declareParameter(new SqlParameter(I_PASSWORD, Types.VARCHAR));
        declareParameter(new SqlParameter(I_CSTNO, Types.INTEGER));
        declareParameter(new SqlParameter(I_COUNTRY, Types.VARCHAR));
        declareParameter(new SqlParameter(I_REF, Types.VARCHAR));


        declareParameter(new SqlOutParameter(O_SID, Types.INTEGER));
        compile();
    }

    public Integer execute(User user) {

        Integer responseInt = FAILED;

        Map<String, Object> params = new HashMap<>();
        params.put(I_FIRSTNAME, user.getFirstname() );
        params.put(I_LASTNAME, user.getLastname() );
        params.put(I_EMAIL, user.getEmail() );
        params.put(I_USERNAME, user.getUsername() );
        params.put(I_PASSWORD,user.getUserpwd() );
        params.put(I_CSTNO, user.getCstno());
        params.put(I_COUNTRY, user.getCountry() );
        params.put(I_REF, user.getUser_ref());



        try {
            Map<String, Object> result = super.execute(params);
            if (result != null && result.get(O_SID) != null) {
                responseInt = (Integer) result.get(O_SID);
            }
        } catch (DataAccessException e) {
            LOGGER.error("Failed to add user: " + user.getCountry(), e);
            return responseInt;
        }

        return responseInt;
    }
}
