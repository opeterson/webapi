package ca.owenpeterson.web.api;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.owenpeterson.web.api.client.model.ApiServerStatusResponse;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-02-18T06:47:31.065312200-06:00[America/Chicago]")
@Controller
@RequestMapping("${openapi.owenpetersonCa.base-path:/}")
public class WebApiController implements WebApi {

	@Override
	public ResponseEntity<ApiServerStatusResponse> getServerStatus() {
		// TODO Auto-generated method stub
		return WebApi.super.getServerStatus();
	}
}
