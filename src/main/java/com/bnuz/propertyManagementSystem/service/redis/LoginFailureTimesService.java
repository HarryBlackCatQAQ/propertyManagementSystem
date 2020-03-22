package com.bnuz.propertyManagementSystem.service.redis;

public interface LoginFailureTimesService {

    public boolean checkIpLoginTimes(String ip);

    public void delLoginFailTimes(String ip);
}
