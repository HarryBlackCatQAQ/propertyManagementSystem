package com.bnuz.propertyManagementSystem.service;

import com.bnuz.propertyManagementSystem.model.Result;
import com.bnuz.propertyManagementSystem.model.User;

public interface RegisteredService {

    public Result checkUserName(String username);

    public Result registeredUser(User user);
}
