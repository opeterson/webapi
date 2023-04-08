package ca.owenpeterson.web.api;

import ca.owenpeterson.web.api.client.model.ApiDefaultError;
import ca.owenpeterson.web.api.client.model.ApiServerStatus;
import ca.owenpeterson.web.api.service.ApiServerStatusServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ApiServerStatusServiceImpl serverStatusService;

	@Override
	public ResponseEntity<ApiServerStatusResponse> getServerStatus() {

		LOGGER.debug("Fetching server status.");
		ApiServerStatusResponse response = new ApiServerStatusResponse();
		ApiServerStatus savedServerStatus = serverStatusService.getServerStatusById(1);

		if (null != savedServerStatus) {
			response.setServerStatus(savedServerStatus);
		} else {
			ApiDefaultError error = new ApiDefaultError();
			error.setErrorMessage("Unable to determine server status.");
			response.setError(error);
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
