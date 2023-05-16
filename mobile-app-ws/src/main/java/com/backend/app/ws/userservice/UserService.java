package com.backend.app.ws.userservice;

import com.backend.app.ws.ui.model.request.UserDetailsRequestModel;
import com.backend.app.ws.ui.model.response.UserRest;

public interface UserService {
    UserRest createUser(UserDetailsRequestModel userDetails);
}
