#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.resource;

import ${package}.dao.UserDao;

import ${package}.types.restReponse.RestResponseCode;
import ${package}.types.User;
import ${package}.types.restReponse.RestResponseHandler;
import com.wordnik.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/v1/users")
@Api(value = "/v1/user", description = "Get user info")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class MathmasterService {

	final static Logger logger = Logger.getLogger(MathmasterService.class);

	private static final String PARAM_USER_ID = "userid";
	private static final String PARAM_USER= "user";
	private static final String URL_ADD_USER= "/addUser";

	private static final String ERROR_CODE_GET_USER = "FAILED_GET_USER";
	private static final String ERROR_CODE_ADD_USER = "FAILED_ADD_USER";

	@Autowired
	UserDao userDao;


	@POST
	@Path(URL_ADD_USER)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@ApiOperation(value = "Add user", notes = "Post req user",
			response = Integer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful update"),
			@ApiResponse(code = 404, message = "Not modified")
	})
	public Response addUser(
			@ApiParam(value = PARAM_USER, required = true)
			User user) {

		logger.debug("Add user: "+ userDao.toString());
		Integer sid = userDao.addUser(user);
		if(sid == 0){
			logger.debug("Failed adding user with cstno: "+user.getCstno());
			return RestResponseHandler.errorHandler(Response.Status.BAD_REQUEST,
					RestResponseCode.ERROR_CODE_POST, ERROR_CODE_ADD_USER);
		}

		return RestResponseHandler.successHandlerSid(sid);
	}

	@GET
	@Path("/{"+PARAM_USER_ID+"}")
	@ApiOperation(value = "Get user info based on sid.", notes = "GET it",
			response = User.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful update"),
			@ApiResponse(code = 404, message = "Not modified")
	})
	public Response getUser(
			@ApiParam(value = PARAM_USER_ID, required = true)
			@PathParam(PARAM_USER_ID) Integer userid) {


		logger.debug("GET user: "+userid);
		List<User> users = userDao.getUser(userid);
		if(users == null){
			logger.debug("GET failed getting user on sid : "+userid);
			return RestResponseHandler.errorHandler(Response.Status.BAD_REQUEST,
					RestResponseCode.ERROR_CODE_GET, ERROR_CODE_GET_USER);

		}

		logger.debug("GET user result: "+users.toString());
		return RestResponseHandler.successHandlerUser(users);
	}



	/*@POST
	@Path("/{"+PARAM_USER+"}")
	@ApiOperation(value = "Add user.", notes = "Post req it",
			response = Integer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful Post"),
			@ApiResponse(code = 404, message = "Not modified")
	})
	public Response addUser(
			@ApiParam(value = PARAM_USER, required = true)
			@PathParam(PARAM_USER) User user) {


			//logger.debug("Add user: "+ userDao.toString());
			//Integer sid = userDao.addUser(user);

		return RestResponseHandler.errorHandler(Response.Status.BAD_REQUEST,
				RestResponseCode.ERROR_CODE_GET, ERROR_CODE_GET_USER);


			if(sid == null){
				logger.debug("GET failed getting user on sid : "+user.toString());
				return RestResponseHandler.errorHandler(Response.Status.BAD_REQUEST,
					RestResponseCode.ERROR_CODE_GET, ERROR_CODE_GET_USER);

			}


			//logger.debug("User added: "+sid);
			//return RestResponseHandler.successHandlerSid(1);


	}*/




 
}