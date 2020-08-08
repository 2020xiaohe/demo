package com.ffcs.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.ffcs.demo.dao.mapper.CartMapper;
import com.ffcs.demo.domain.AlipayBean;
import com.ffcs.demo.service.AlipayService;
import com.ffcs.demo.utils.alipay.AlipayConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * create by clr on 2020/8/5
 */
@Service
public class AlipayServiceImpl implements AlipayService {

    @Override
    public String alipay(AlipayBean alipayBean) throws AlipayApiException {
        // 1、获得初始化的AlipayClient
        AlipayConfig alipayConfig= new AlipayConfig();
        String serverUrl = alipayConfig.getGatewayUrl();
        String appId = alipayConfig.getApp_id();
        String privateKey = alipayConfig.getMerchant_private_key();
        String format = "json";
        String charset = alipayConfig.getCharset();
        String alipayPublicKey = alipayConfig.getAlipay_public_key();
        String signType = alipayConfig.getSign_type();
        String returnUrl = alipayConfig.getReturn_url();
        String notifyUrl = alipayConfig.getNotify_url();
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
        // 2、设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        // 页面跳转同步通知页面路径
        alipayRequest.setReturnUrl(returnUrl);
        // 服务器异步通知页面路径
        alipayRequest.setNotifyUrl(notifyUrl);
        // 封装参数
        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
        // 3、请求支付宝进行付款，并获取支付结果
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        // 返回付款信息
        System.out.println("result"+result);
        return result;
    }

    @Override
    public String refund(AlipayBean alipayBean) throws AlipayApiException {
        // 1、获得初始化的AlipayClient
        AlipayConfig alipayConfig= new AlipayConfig();
        String serverUrl = alipayConfig.getGatewayUrl();
        String appId = alipayConfig.getApp_id();
        String privateKey = alipayConfig.getMerchant_private_key();
        String format = "json";
        String charset = alipayConfig.getCharset();
        String alipayPublicKey = alipayConfig.getAlipay_public_key();
        String signType = alipayConfig.getSign_type();
        String returnUrl = alipayConfig.getReturn_url();
        String notifyUrl = alipayConfig.getNotify_url();
        AlipayClient alipayClient = new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        //商户订单号，必填
        String out_trade_no = new String(alipayBean.getOut_trade_no());
        //需要退款的金额，该金额不能大于订单金额，必填
        String refund_amount = new String(alipayBean.getTotal_amount());
        //标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
       String out_request_no = new String(UUID.randomUUID().toString());
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"refund_amount\":\""+ refund_amount +"\","
                + "\"out_request_no\":\""+ out_request_no +"\"}");
        //alipayRequest.setBizContent(JSON.toJSONString(alipayBean));
        //请求
        String result = alipayClient.execute(alipayRequest).getBody();
        // 返回付款信息
        System.out.println("result"+result);
        return result;
    }
}
