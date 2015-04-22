package com.robsan.dao.sp;

import com.robsan.dao.rowmapper.UserRowmapper;
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
import oracle.jdbc.OracleTypes;


import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by lordofeverything on 08/02/15.
 */
@Component
public class GetUserSP extends StoredProcedure {


    final static Logger LOGGER = Logger.getLogger(GetUserSP.class);

    public static final String SP_GET_USER = "PKG_MATHMASTER.sp_get_user";
    public static final String I_SID = "i_sid";
    public static final String O_ACCOUNTS = "o_accounts";

    @Autowired
    public GetUserSP(@Qualifier("oracleJdbcTemplate") JdbcTemplate jdbcTemplate, UserRowmapper userRowMapper) {

        super(jdbcTemplate, SP_GET_USER);

        declareParameter(new SqlParameter(I_SID, Types.INTEGER));
        declareParameter(new SqlOutParameter(O_ACCOUNTS, OracleTypes.CURSOR, userRowMapper));
        compile();
    }

    public List<User> execute(Integer sid) {

       List<User> results= new ArrayList<>();

        Map<String, Object> params = new HashMap<>();
        params.put(I_SID, sid );

        try {
            Map<String, Object> out = super.execute(params);
            if (out != null && !out.isEmpty() && (out.get(O_ACCOUNTS) != null)) {
                results.addAll((List<User>) out.get(O_ACCOUNTS));
            }
        } catch (DataAccessException e) {
            LOGGER.error("Failed to get user on sid:"+ sid, e);
            return null;
        }

        return results;
    }
}
