package com.appster.abdullah.module.userStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appster.abdullah.entity.User;
import com.appster.abdullah.module.userStatistics.service.UserstatService;
import com.appster.abdullah.util.ResponseEnvelope;

@RestController
@RequestMapping("/api/v1/userstats")
public class UserStatisticsController {

	private UserstatService userstatService;

	@Autowired
	public UserStatisticsController(UserstatService userstatService) {
		this.userstatService = userstatService;
	}

	@RequestMapping("/{id}")
	@ResponseBody
	public ResponseEntity<ResponseEnvelope> testRest(Long id) {
		System.out.println("Webservice called successfully");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<ResponseEnvelope> addUser(@RequestBody @Validated User userData) {
		User newUser = userstatService.addUser(userData);
		return new ResponseEntity<ResponseEnvelope>(new ResponseEnvelope(newUser, "Success"), HttpStatus.OK);
	}

}
