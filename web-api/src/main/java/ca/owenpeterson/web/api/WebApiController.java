package ca.owenpeterson.web.api;

import ca.owenpeterson.web.api.domain.ServerStatus;
import ca.owenpeterson.web.api.service.ServerStatusServiceImpl;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.owenpeterson.web.api.client.model.ApiServerStatusResponse;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-02-18T06:47:31.065312200-06:00[America/Chicago]")
@Controller
@RequestMapping("${openapi.owenpetersonCa.base-path:/}")
public class WebApiController implements WebApi {

	private static final Logger LOGGER = LogManager.getLogger(WebApiController.class);

	@Autowired
	private ServerStatusServiceImpl serverStatusService;

	@Override
	public ResponseEntity<ApiServerStatusResponse> getServerStatus() {

		LOGGER.debug("Fetching server status.");
		ApiServerStatusResponse response = new ApiServerStatusResponse();

		ServerStatus serverStatus = new ServerStatus();
		serverStatus.setStatus("ONLINE");
		serverStatus.setStartUpTime(LocalDateTime.now());
		serverStatusService.saveServerStatus(serverStatus);

		ServerStatus savedServerStatus = serverStatusService.getServerStatusById(1);

		//TODO: write transformer for this.
		if (null != savedServerStatus) {
			response.setDbStatus(serverStatus.getStatus());
			//TODO: make a util class for time conversions
			ZoneId winnipeg = ZoneId.of("America/Winnipeg").getRules().getOffset(Instant.now());
			response.setDbStartTime(serverStatus.getStartUpTime().atOffset(ZoneOffset.of(winnipeg.getId())));
		} else {
			response.setDbStatus("ERROR_STATE");
		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
