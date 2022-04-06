package org.nha.requestor_service.Requestor_service.controller;

import javax.validation.Valid;
import org.nha.requestor_service.Requestor_service.service.RequestorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhp.sdk.beans.Response;

/**
 * @author Deepak Kumar
 *
 */
@RestController
@Validated
@RequestMapping("/requestor")
public class RequestorServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RequestorServiceController.class);

	@Autowired
	RequestorService Requestorservice;

	@PostMapping(value = "/api/v1/search", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response> search(@Valid @RequestBody String req) {
		LOGGER.info("Search request| " + req);
		return ResponseEntity.status(HttpStatus.OK).body(Requestorservice.process(req));
	}

	@PostMapping(value = "/api/v1/on_search", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Response> on_search(@Valid @RequestBody String req) {
		LOGGER.info("on_Search request| " + req);
		return ResponseEntity.status(HttpStatus.OK).body(Requestorservice.generateAck(req));
	}

}
