package core.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	Logger logger = LogManager.getLogger(Controller.class);
	
	@RequestMapping(value="/test" ,method= RequestMethod.GET)
    public ResponseEntity<String> test(@RequestHeader(value = "User-Agent") String userAgent) {
        try {
        	logger.error("userAgent: " + userAgent);
            return new ResponseEntity<>("response\n", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
}
