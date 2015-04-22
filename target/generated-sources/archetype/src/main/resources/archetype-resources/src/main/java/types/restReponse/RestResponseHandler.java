#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.types.restReponse;

import ${package}.types.User;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by lordofeverything on 17/03/15.
 */
public class RestResponseHandler {

    public static Response errorHandler(Response.Status status, RestResponseCode errorCode, String errorTex){
        return Response
                .status(status)
                .entity(new RestResponse(errorCode, errorTex))
                .build();
    }

    public static Response successHandlerSid(Integer sid){
        return Response
                .status(Response.Status.OK)
                .entity(new RestResponse(sid))
                .build();

    }

    public static Response successHandlerUser(List<User> result){

        return Response.ok(new GenericEntity<List<User>>(result) {
        }).build();
    }
}
