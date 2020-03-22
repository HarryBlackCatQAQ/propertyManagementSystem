package com.bnuz.propertyManagementSystem.service;

import com.niezhiliang.simple.pay.vos.AlipayCallBackVO;

public interface PropertyManagementFeeService {

    public Object aliPayQRCode(String outTradeNo);

    public String aliPayPcpay(String outTradeNo);

    public String aliPayCallBack(AlipayCallBackVO aliPayCallBackVO);
}
