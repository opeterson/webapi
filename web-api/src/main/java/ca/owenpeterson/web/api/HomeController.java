package ca.owenpeterson.web.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Home redirection to OpenAPI api documentation
 */
@Controller
public class HomeController {

	private static final Logger LOGGER = LogManager.getLogger(HomeController.class);
	
    @RequestMapping("/")
    public String index() {
    	LOGGER.debug("Redirecting to api documentation.");
        return "redirect:swagger-ui.html";
    }


}
