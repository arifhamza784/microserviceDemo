package com.backend.app.ws.userservice.impl;

import com.backend.app.ws.ui.model.request.UserDetailsRequestModel;
import com.backend.app.ws.ui.model.response.UserRest;
import com.backend.app.ws.userservice.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    Map<String, UserRest> users;

    public UserRest createUser(UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());

        String userId = UUID.randomUUID().toString();
        returnValue.setUserId(userId);

        if (users == null) users = new HashMap<>();

        users.put(userId, returnValue);

       return returnValue;

    }
}
