package com.bnuz.propertyManagementSystem.service;

import com.niezhiliang.simple.pay.vos.AlipayCallBackVO;

public interface PropertyManagementFeeService {

    public Object aliPay(String outTradeNo);

    public String aliPayCallBack(AlipayCallBackVO aliPayCallBackVO);
}
