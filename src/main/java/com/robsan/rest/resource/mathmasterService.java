package com.robsan.rest.resource;
 
import com.robsan.types.RestResponse;
import com.wordnik.swagger.annotations.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/v1/users")
@Api(value = "/v1/user", description = "Get user info")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class mathmasterService {

	private static final String ERROR_CODE_GET = "ERROR_CODE_GET";
	private static final String ERROR_CODE_POST= "ERROR_CODE_GET";

	private static final String PARAM_USER_ID = "userid";

	@GET
	@Path("/{"+PARAM_USER_ID+"}")
	@ApiOperation(value = "Get user info based on sid.", notes = "GET it",
			response = Integer.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful update"),
			@ApiResponse(code = 404, message = "Not modified")
	})
	public Response getUser(
			@ApiParam(value = PARAM_USER_ID, required = true)
			@PathParam(PARAM_USER_ID) Integer userid) {

		String output = "Jersey say wites  : " + userid;


		//return errorHandler(Response.Status.BAD_REQUEST, ERROR_CODE_GET, msg);
		return successHandler(1);

 
	}




	private Response errorHandler(Response.Status status, String code, String text){
		RestResponse response = new RestResponse();
		response.setErrorCode(code);
		response.setErrorText(text);
		return Response.status(status).entity(response).build();
	}

	private Response successHandler(Integer sid){
		RestResponse response = new RestResponse();
		response.setSid(sid);
		return Response.ok(response).build();
	}

	private Response successHandler(List<RestResponse> result){
		return Response.ok(new GenericEntity<List<RestResponse>>(result) {
		}).build();
	}
 
}