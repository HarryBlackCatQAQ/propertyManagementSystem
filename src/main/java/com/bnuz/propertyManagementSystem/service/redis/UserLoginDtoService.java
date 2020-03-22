package com.bnuz.propertyManagementSystem.service.redis;

import com.bnuz.propertyManagementSystem.dto.UserLoginDto;

public interface UserLoginDtoService {

    public static final String UserLoginDtoRedisPre = "UserLoginDto";

    public void save(UserLoginDto userLoginDto,String ip);
}
