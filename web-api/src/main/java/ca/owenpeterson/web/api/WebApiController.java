package ca.owenpeterson.web.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.owenpeterson.web.api.client.model.ApiServerStatusResponse;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-02-18T06:47:31.065312200-06:00[America/Chicago]")
@Controller
@RequestMapping("${openapi.owenpetersonCa.base-path:/}")
public class WebApiController implements WebApi {

	private static final Logger LOGGER = LogManager.getLogger(WebApiController.class);
	@Override
	
	public ResponseEntity<ApiServerStatusResponse> getServerStatus() {
		// TODO Auto-generated method stub
		LOGGER.debug("Fetching server status.");
		ApiServerStatusResponse response = new ApiServerStatusResponse();
		response.setDbStatus("MOCKED");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
