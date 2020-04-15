package com.bnuz.propertyManagementSystem.controller;

import com.bnuz.propertyManagementSystem.dao.HouseFeeRecordDao;
import com.bnuz.propertyManagementSystem.model.*;
import com.bnuz.propertyManagementSystem.service.OutTradeNoFactoryService;
import com.bnuz.propertyManagementSystem.service.PropertyManagementFeeService;
import com.niezhiliang.simple.pay.utils.PayUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author: Harry
 * @Date: 2019-10-24 13:02
 * @Version 1.0
 */
@RestController
@RequestMapping("/alipay")
@Api(tags = "支付宝支付相关接口")
public class AlipayController {

    @Autowired
    private OutTradeNoFactoryService outTradeNoFactoryService;

    @Autowired
    private PropertyManagementFeeService propertyManagementFeeService;

    @GetMapping(value = "/payPropertyManagementFee/QRCode")
    public Object aliPayQRCode(String outTradeNo){
        return propertyManagementFeeService.aliPayQRCode(outTradeNo);
    }

    @GetMapping(value = "/payPropertyManagementFee/pcPay")
    public String aliPayPcpay(String outTradeNo){
        return propertyManagementFeeService.aliPayPcpay(outTradeNo);
    }


    @PostMapping(value = "/callback")
    public String payCallBack(HttpServletRequest request){
        return propertyManagementFeeService.aliPayCallBack(PayUtils.alipayPayCallBack(request));
    }

    @Autowired
    private HouseFeeRecordDao houseFeeRecordDao;

    @GetMapping("/testData")
    public Object insert(){
        List<HouseFeeRecord> list = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            HouseFeeRecord houseFeeRecord = new HouseFeeRecord();
            double fee = i * 10 + 0.28;
            houseFeeRecord.setFee(fee);
            houseFeeRecord.setIsPaid(false);
            houseFeeRecord.setMonth(10);
            houseFeeRecord.setYear(2019);
            houseFeeRecord.setOutTradeNo(outTradeNoFactoryService.getOrderCode());
            houseFeeRecord.setBuildingId(2);
            houseFeeRecord.setPropertyId(3);
            houseFeeRecord.setHouseId(i % 3 + 1);

            houseFeeRecordDao.save(houseFeeRecord);
            list.add(houseFeeRecord);
        }

        houseFeeRecordDao.flush();

        return list;
    }

}