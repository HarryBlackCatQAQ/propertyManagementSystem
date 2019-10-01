package com.bnuz.propertyManagementSystem.service.redis;

public interface JWTRedisService {
    /**
     * Redis中的 token hash表 名字
     */
    public final static String TOKEN_HASH = "TOKEN_HASH";

    /**
     * 获取 redis中的token
     * @param userName
     * @return
     */
    public Object getToken(String userName);

    /**
     * token存入redis key:userName val token
     * @param userName
     * @param token
     * @return
     */
    public boolean saveToken(String userName,String token);

    /**
     * 删除redis中的token
     * @param userName
     * @return
     */
    public boolean delToken(String userName);

    /**
     * 判断redis是否存在该token
     * @param userName
     * @return
     */
    public boolean hasToken(String userName);
}
