package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.service.OutTradeNoFactoryService;
import com.bnuz.propertyManagementSystem.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * @Author: Harry
 * @Date: 2019-10-24 16:50
 * @Version 1.0
 */

/**
 ** 订单编码码生成器，生成32位数字编码，
 ** @生成规则 1位单号类型+17位时间戳+14位(用户id加密&随机数)
 *  
 */
@Service
public class OutTradeNoFactoryServiceImpl implements OutTradeNoFactoryService {
    /**
     * 订单类别头
     */
    private static final String ORDER_CODE = "1";

    /**
     * 随即编码
     */
    private static final int[] r = new int[]{7, 9, 6, 2, 8, 1, 3, 0, 5, 4};

    /**
     * 用户id和随机数总长度
     */
    private static final int maxLength = 14;

    @Autowired
    private DateUtil dateUtil;


    /**
     ** 生成订单单号编码
     ** @param userId
     *      
     */
    public String getOrderCode(Long userId) {
        return ORDER_CODE + getCode(userId);
    }

    /**
     ** 生成不带标头订单单号编码
     **
     *      
     */
    public String getOrderCode() {
        return ORDER_CODE + getCode(null);
    }

    /**
     ** 判断生不生成 带类别标头的编码
     ** @param userId
     *      
     */
    private String getCode(Long userId) {
        userId = userId == null ? 10000 : userId;
        return getDateTime() + toCode(userId);
    }

    /**
     ** 更具id进行加密+加随机数组成固定长度编码
     *      
     */
    private String toCode(Long id) {
        String idStr = id.toString();
        StringBuilder idsbs = new StringBuilder();
        for (int i = idStr.length() - 1; i >= 0; i--) {
            idsbs.append(r[idStr.charAt(i) - '0']);
        }
        return idsbs.append(getRandom(maxLength - idStr.length())).toString();
    }

    /**
     ** 生成时间戳
     *      
     */
    private String getDateTime() {
        return dateUtil.formatLLDateTime(new Date());
    }

    /**
     ** 生成固定长度随机码
     ** @param n    长度
     *      
     */
    private long getRandom(long n) {
        long min = 1, max = 9;
        for (int i = 1; i < n; i++) {
            min *= 10;
            max *= 10;
        }
        long rangeLong = (((long) (new Random().nextDouble() * (max - min)))) + min;
        return rangeLong;
    }




}