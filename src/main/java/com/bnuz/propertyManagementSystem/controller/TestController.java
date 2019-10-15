package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.dao.ComplaintAndSuggestionSheetDao;
import com.bnuz.propertyManagementSystem.dao.UserDao;
import com.bnuz.propertyManagementSystem.model.ComplaintAndSuggestionSheet;
import com.bnuz.propertyManagementSystem.model.User;
import com.bnuz.propertyManagementSystem.redisson.DistributedLocker;
import com.bnuz.propertyManagementSystem.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 测试Controller
 *
 * @Author: Harry
 * @Date: 2019-09-21 02:57
 * @Version 1.0
 */


@CrossOrigin
@RestController
@RequestMapping(value = "/test")
@Api(tags = "个人测试接口(无作用)")
public class TestController {

//    @PreAuthorize("hasAnyRole('ROLE_0','ROLE_1','ROLE_2')")
    @GetMapping("/t1")
    public String t1(){
        return "t1";
    }

//    @PreAuthorize("hasAnyRole('ROLE_1','ROLE_2')")
    @GetMapping("/t2")
    public String t2(){
        return "t2";
    }

//    @PreAuthorize("hasAnyRole('ROLE_2')")
    @GetMapping("/t3")
    public String t3(){
        return "t3";
    }

    @Autowired
    UserService userService;
    @Autowired
    UserDao userDao;


    @GetMapping("/page")
    public Object page(int pageNum,int size){

        for(int i = 1;i < 105;i++){
            User user = new User();
            user.setUsername("" + i);
            user.setRole((i % 3));
            user.setNickname(user.getUsername());
            user.setPassword(user.getUsername());

            userDao.insert(user);
        }

        return userService.getAllUser(pageNum,size).getData();
    }


    @DeleteMapping("del")
    public String del(@RequestBody User user){
        System.err.println(user);
        return "del  " +  "a:" + user;
    }

    @GetMapping ("/login")
    public String tt1(String username,String password){
        System.out.println(username + " " + password);

        return "ok";
    }


    @GetMapping ("/login3")
    public String tt3(String username,String password){
        System.out.println(username + " " + password);

        return "ok3";
    }

    @PostMapping ("/login2")
    public String tt2(@RequestBody Map<String,String> map){
        System.out.println("2:" + map.get("username") + " " + map.get("password"));

        return "ok2";
    }

    @Autowired
    private ComplaintAndSuggestionSheetDao complaintAndSuggestionSheetDao;

    @GetMapping("/sheet")
    public Object aaaaa(int id){
        System.err.println("id:" + id);
        List<ComplaintAndSuggestionSheet> list = complaintAndSuggestionSheetDao.selectUserComplaintAndSuggestionSheetListByUserId(id);
        System.err.println(list);
        return list;
    }

    @Autowired
    private DistributedLocker distributedLocker;

    @RequestMapping("/redisson")
    public void redissonTest() {
        String key = "redisson_key";
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.err.println("=============线程开启============" + Thread.currentThread().getName());
                        /*
                         * distributedLocker.lock(key,10L); //直接加锁，获取不到锁则一直等待获取锁
                         * Thread.sleep(100); //获得锁之后可以进行相应的处理
                         * System.err.println("======获得锁后进行相应的操作======"+Thread.
                         * currentThread().getName());
                         * distributedLocker.unlock(key); //解锁
                         * System.err.println("============================="+
                         * Thread.currentThread().getName());
                         */
//                        boolean isGetLock = distributedLocker.tryLock(key, TimeUnit.SECONDS, 5L, 10L); // 尝试获取锁，等待5秒，自己获得锁后一直不解锁则10秒后自动解锁
                         distributedLocker.lock(key,TimeUnit.SECONDS,10);
//                        if (isGetLock) {
                            System.out.println("线程:" + Thread.currentThread().getName() + ",获取到了锁");
                            Thread.sleep(100); // 获得锁之后可以进行相应的处理
                            System.err.println("======获得锁后进行相应的操作======" + Thread.currentThread().getName());
//                            distributedLocker.unlock(key);
                            System.err.println("=============================" + Thread.currentThread().getName());
//                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }

//        System.err.println(sheetId);
//        System.err.println(files);
//        System.err.println(files.length);
//        for (MultipartFile file : files) {
//            // ... 处理文件储存逻辑
//            System.err.println(file);
//            System.err.println(file.getName());
//            System.err.println(file.getSize());
//            System.err.println(file.getOriginalFilename());
//            try {
//                System.err.println(file.getInputStream());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            System.err.println(file.getResource());
//            System.err.println(file.getContentType());
//            try {
//                System.err.println(file.getBytes());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
    }


}