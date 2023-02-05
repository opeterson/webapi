package ca.owenpeterson.web.api;

import ca.owenpeterson.web.api.client.model.ApiServerStatusResponse;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Ignore //TODO: implement easymock and tests.
public class WebApiControllerTest {

    private WebApiController controller = new WebApiController();
	@Test
    public void testGetServerStatus()
    {
        ResponseEntity<ApiServerStatusResponse> responseEntity = controller.getServerStatus();
        ApiServerStatusResponse response = responseEntity.getBody();
        assertNotNull(response);
        assertEquals("MOCKED", response.getDbStatus());
    }
}
