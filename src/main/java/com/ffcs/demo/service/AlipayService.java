package com.ffcs.demo.service;

import com.alipay.api.AlipayApiException;
import com.ffcs.demo.domain.AlipayBean;

/**
 * create by clr 2020/8/6
 */
public interface AlipayService {

    /**
     * 支付宝支付调用接口
     */
      String alipay(AlipayBean alipayBean) throws AlipayApiException;
    /**
     * 支付宝退款调用接口
     */
      String refund(AlipayBean alipayBean) throws AlipayApiException;
}
