package com.bnuz.propertyManagementSystem.util;

import com.bnuz.propertyManagementSystem.springsecurity.JwtDate;
import com.bnuz.propertyManagementSystem.springsecurity.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Harry
 * @Date: 2019-09-23 00:36
 * @Version 1.0
 */
public class JwtTokenUtils {

    /**
     *
     */
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "djasid3934*&^^&)7!-dasd2odax_VongHoWing";
    private static final String ISS = "echisan";

    // 时间使用JwtDate管理
    // 过期时间是3600秒，既是1个小时
    private static final int EXPIRATION = 1;
    // 选择了记住我之后的过期时间为7天
    private static final int EXPIRATION_REMEMBER = 7;


    // 添加角色的key
    private static final String ROLE_CLAIMS = "rol";


    // 默认创建token 可选记住我
    public static String createToken(JwtUser jwtUser, String role, boolean isRememberMe) {
        JwtDate jwtDate = new JwtDate();
        if(isRememberMe){
            jwtDate.setDays(EXPIRATION_REMEMBER);
        }
        else{
//            jwtDate.setSeconds(20);
            jwtDate.setHours(EXPIRATION);
        }

        return createTokenImpl(jwtUser,role,jwtDate);
    }

    //自定义过期时间 创建token
    public static String createToken(JwtUser jwtUser,String role,JwtDate jwtDate) {
        return createTokenImpl(jwtUser,role,jwtDate);
    }

    private static String createTokenImpl(JwtUser jwtUser,String role,JwtDate jwtDate){

        HashMap<String, Object> map = new HashMap<>();
        map.put(ROLE_CLAIMS, role);
        map.put("user",jwtUser);

        Date now = new Date(System.currentTimeMillis());
        Date exp = jwtDate.getExp(now);
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)

                .setClaims(map)

                .setIssuer(ISS)
                .setSubject(jwtUser.getUsername())
                .setIssuedAt(now)
                .setExpiration(exp)
                .compact();
    }


    // 从token中获取用户名
    private static String getUsername(String token){
        return getTokenBody(token).getSubject();
    }

    // 从token中获取权限角色
    private static String getUserRole(String token){
        return (String)getTokenBody(token).get("rol");
    }

    /**
     * 验证jwt
     */
    public static Claims verifyJwt(String token) {
        //签名秘钥，和生成的签名的秘钥一模一样
        SecretKey key = generalKey();
        Claims claims;
        try {
            claims = Jwts.parser()  //得到DefaultJwtParser
                    .setSigningKey(key)         //设置签名的秘钥
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }//设置需要解析的jwt

        return claims;
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    private static SecretKey generalKey() {
        String stringKey = SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    // 是否已过期
    public static boolean isExpiration(String token){
        token = token.replace(TOKEN_PREFIX, "");
        Claims claims = getTokenBody(token);
        if(claims == null){
            return true;
        }

        return claims.getExpiration().before(new Date());
    }


    public static Map<String,Object> parsingToken(String tokenHeader){
        Map<String,Object> map = new HashMap<>();

        String token = tokenHeader.replace(TOKEN_PREFIX, "");
        String username = JwtTokenUtils.getUsername(token);

        String role = JwtTokenUtils.getUserRole(token);

        String roles[] = role.split(" ");

        map.put("oldToken",tokenHeader);
        map.put("token",token);
        map.put("username",username);
        map.put("roles",roles);

        return map;
    }

    private static Claims getTokenBody(String token){
        Claims claims;

        try{
            claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            System.err.println(e);
            claims = null;
        }

        return claims;
    }
}
