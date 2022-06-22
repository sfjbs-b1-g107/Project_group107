
package com.tcs.Project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/")
	String getPublicMessage() {
		return "Hello everyone";
	}
	
	@GetMapping("/users")
	String getUserMessage() {
		return "Hi User, you are now logged in...";
	}
}
