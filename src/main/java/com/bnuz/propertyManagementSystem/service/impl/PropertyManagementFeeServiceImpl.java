package com.bnuz.propertyManagementSystem.service.impl;

import com.bnuz.propertyManagementSystem.dao.HouseFeeRecordDao;
import com.bnuz.propertyManagementSystem.model.*;
import com.bnuz.propertyManagementSystem.service.PropertyManagementFeeService;
import com.niezhiliang.simple.pay.dto.AlipayPcPayDTO;
import com.niezhiliang.simple.pay.dto.AlipayQrcodeDTO;
import com.niezhiliang.simple.pay.utils.PayUtils;
import com.niezhiliang.simple.pay.vos.AlipayCallBackVO;
import com.niezhiliang.simple.pay.vos.AlipayQrcodeVO;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


/**
 * @Author: Harry
 * @Date: 2019-10-25 02:28
 * @Version 1.0
 */
@Service("PropertyManagementFeeServiceImpl")
@Slf4j
public class PropertyManagementFeeServiceImpl implements PropertyManagementFeeService {

    @Autowired
    private HouseFeeRecordDao houseFeeRecordDao;

    @Autowired
    private SimpMessagingTemplate template;

    @Override
    public Object aliPayQRCode(String outTradeNo) {
        HouseFeeRecord houseFeeRecord = houseFeeRecordDao.getByOutTradeNo(outTradeNo);

//        String name = "";
//        Property property = houseFeeRecord.getHouse().getBuilding().getProperty();
//        Building building = houseFeeRecord.getHouse().getBuilding();
//        House house = houseFeeRecord.getHouse();
//        name += property.getLocation() + property.getName();
//        name += building.getName();
//        name += house.getNumber();
//        name += " 物业费";
        String name = houseFeeRecord.getPaymentName();

        AlipayQrcodeDTO alipayQrcodeDTO = new AlipayQrcodeDTO();
        alipayQrcodeDTO.setOutTradeNo(houseFeeRecord.getOutTradeNo());
        alipayQrcodeDTO.setTotalAmount(houseFeeRecord.getFee());
        alipayQrcodeDTO.setSubject(name);

        AlipayQrcodeVO alipayQrcodeVO = null;



        AlipayPcPayDTO pcPayDTO = new AlipayPcPayDTO();
        pcPayDTO.setOutTradeNo(houseFeeRecord.getOutTradeNo());
        pcPayDTO.setTotalAmount(houseFeeRecord.getFee());
        pcPayDTO.setSubject(name);
        String form = PayUtils.alpayPcPay(pcPayDTO);

        return form;



//        try{
//            alipayQrcodeVO = PayUtils.alipayQrcode(alipayQrcodeDTO);
//        }
//        catch (Exception e){
//            log.error("alipay连接超时");
//        }
//
////        System.err.println(alipayQrcodeVO);
//
//        if(alipayQrcodeVO == null){
//            return new Result(false,ResultStatusCode.ERROR,ResultStatusCode.ERROR_MES_SYS);
//        }
//
//
//        if(alipayQrcodeVO.getCode().equals("10000")){
//            String str =
//                    "forward:/QRcode/create?qrCodeUrl=" + alipayQrcodeVO.getQr_code();
//
//            return new ModelAndView(str);
//        }
//        else{
//            return new Result(false,ResultStatusCode.ERROR,ResultStatusCode.ERROR_MES_SYS);
//        }
    }

    @Override
    public String aliPayPcpay(String outTradeNo) {
        HouseFeeRecord houseFeeRecord = houseFeeRecordDao.getByOutTradeNo(outTradeNo);

        String name = houseFeeRecord.getPaymentName();

        AlipayPcPayDTO alipayPcPayDTO = new AlipayPcPayDTO();
        alipayPcPayDTO.setOutTradeNo(outTradeNo);
        alipayPcPayDTO.setTotalAmount(houseFeeRecord.getFee());
        alipayPcPayDTO.setSubject(name);
        alipayPcPayDTO.setBody(name);

        String url = PayUtils.alpayPcPay(alipayPcPayDTO);
        return url;
    }

    @Override
    public String aliPayCallBack(AlipayCallBackVO aliPayCallBackVO) {
        //支付成功通过websocket将回调结果返回给前端，我们生产环境需要判断是否回调结果状态并改变数据库中订单的值

        log.info(aliPayCallBackVO.toString());
        log.info("状态:" + aliPayCallBackVO.getTrade_status());

        if(aliPayCallBackVO.getTrade_status().equals("TRADE_SUCCESS")) {
            log.info("单号" + aliPayCallBackVO.getOut_trade_no() + "支付成功");
            HouseFeeRecord houseFeeRecord = houseFeeRecordDao.getByOutTradeNo(aliPayCallBackVO.getOut_trade_no());
            if(houseFeeRecord != null){
                houseFeeRecord.setIsPaid(true);
                houseFeeRecord.setPayType("支付宝");
                houseFeeRecord.setPayTime(new Date());
                houseFeeRecordDao.saveAndFlush(houseFeeRecord);
                this.template.convertAndSend("/topic/alipayCallback", "success");
            }
        }
        //返回给支付宝回调的接口的'SUCCESS'已经封装好了,如果不是成功，则该值为'FAILER'
        return aliPayCallBackVO.getShouldResonse();
    }
}