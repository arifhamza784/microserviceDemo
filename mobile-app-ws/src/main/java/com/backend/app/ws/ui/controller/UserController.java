package com.backend.app.ws.ui.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.backend.app.ws.exceptions.UserserviceException;
import com.backend.app.ws.userservice.UserService;
import jakarta.validation.constraints.Null;
import org.hibernate.validator.cfg.context.ReturnValueConstraintMappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.backend.app.ws.ui.model.request.UserDetailsRequestModel;
import com.backend.app.ws.ui.model.response.UserRest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", required = false) String sort) { //it is better we user required feild with non primitive data type only as they can be initiated with null value

        return "get user was called with page = " + page + " and limit = " + limit + "and sort = " + sort;
    }

//	@GetMapping(path="/{userId}",
//				produces = {MediaType.APPLICATION_XML_VALUE, 
//							MediaType.APPLICATION_JSON_VALUE})
//	public UserRest getUser(@PathVariable String userId) {
//
//		UserRest returnValue = new UserRest();
//		
//		returnValue.setFirstName("Hamza");
//		returnValue.setLastName("Arif");
//		returnValue.setEmail("test@gmail.com");
//		
//		return returnValue;
//	}

    /*Below is an example setting custom HttpStatus to a request method*/
    @GetMapping(path = "/{userId}",
            produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

        if (true) throw new UserserviceException("User service exception is thrown");

        if (users.containsKey(userId)) {
            return new ResponseEntity<>(users.get(userId), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_XML_VALUE,
            MediaType.APPLICATION_JSON_VALUE},

            produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

        UserRest returnValue = userService.createUser(userDetails);

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}",
            consumes = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE},

            produces = {MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE})
    public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserDetailsRequestModel userDetails) {

        //Retrieving saved user
        UserRest storedUserDetails = users.get(userId);

        //updating saved user
        storedUserDetails.setFirstName(userDetails.getFirstName());
        storedUserDetails.setLastName(userDetails.getLastName());

        //saving saved user
        users.put(userId, storedUserDetails);

        return storedUserDetails;
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable String userId) {

        if (!users.containsKey(userId)) {
            return new ResponseEntity<String>("No user found", HttpStatus.BAD_REQUEST);
        } else {
            users.remove(userId);
            return new ResponseEntity<String>("User deleted successfully", HttpStatus.OK);
        }
    }
}
