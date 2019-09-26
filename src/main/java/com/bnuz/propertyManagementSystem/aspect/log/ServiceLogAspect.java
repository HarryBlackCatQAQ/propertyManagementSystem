package com.bnuz.propertyManagementSystem.aspect.log;

import com.alibaba.fastjson.JSONObject;
import com.bnuz.propertyManagementSystem.model.ImageCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Service 日志切面
 *
 * @Author: Harry
 * @Date: 2019-09-24 17:46
 * @Version 1.0
 */
@Slf4j
@Component
@Aspect
public class ServiceLogAspect {

    /**
     * 　　* 切面
     *
     */
    private final String POINT_CUT = "execution(* com.bnuz.propertyManagementSystem.service.*.*.*(..))";

    @Pointcut(POINT_CUT)
    private void pointcut() {
    }

    @Before(value = POINT_CUT)
    public void before(JoinPoint joinPoint) {
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        StringBuilder logs = new StringBuilder();

        Object[] args = joinPoint.getArgs();
        int counter = 0;
        for (Object arg : args) {
            if(counter++ != 0){
                logs.append(", ");
            }
            logs.append(JSONObject.toJSONString(arg));
        }

        log.info("<<----------------------start------------------------->>");
        log.info("before:");
        log.info("class : " + className);
        log.info("method : " + methodName);
        log.info("params : {" + logs.toString() + "}");
    }

    @AfterReturning(value = "pointcut()", returning = "returnObj")
    public void afterReturn(Object returnObj) {
        String result = null;
        if(!(returnObj instanceof ImageCode)){
            result = JSONObject.toJSONString(returnObj);

            result = sub(result);
        }

        log.info("afterReturning : " + result);
        log.info("<<------------------------end------------------------->>");
    }

    private String sub(String result){
        int a = result.indexOf("code");
        int b = result.indexOf("expireTime");
        int c = result.indexOf("colorModel");

        if(a > 0 && b > 0 && c > 0){
            int start = result.indexOf("code") + 7;
            int end = start + 4;
            String code = result.substring(start,end);
            return "code:" + code;
        }


        return result;
    }

    @AfterThrowing(value = POINT_CUT, throwing = "e")
    public void afterThrowing(Throwable e) {
        log.error("afterThrowing: " + e.getMessage(), e);
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long begin = System.currentTimeMillis();
        StringBuilder logs = new StringBuilder("around : ");
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            log.error(logs + e.getMessage(), e);
        }
        Long end = System.currentTimeMillis();
        logs.append(" 执行时间 : ")
                .append(end - begin)
                .append("ms");

        log.info(logs.toString());
        return result;
    }

}