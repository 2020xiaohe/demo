package com.ffcs.demo.utils.alipay;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 * create by clr
 */

public class AlipayConfig {
	

	// 应用ID,APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016102300743915";

	// 商户私钥，PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC44wPZcR/zVioRG+hWDND6E8qMeSyhTzpEIycgw54CtJ0rIF8fFPp/rVW49FJqN4IKoDYrX3fFvlwnL3fXdmvvo7zHMc7i7EP0tiB5ZzFytaU7mhcGHnrQmw6kQi7C1DIknlPJ9LBH4k06AWiZY9ZMB/Df0L/z2W5022f+17azWVTrr6jyld7SAmAvnVoNfAay0Y3ADAEzAREVMeWHQUTZQVKaWu51kTaQQw/AI2ZEKT2NMPLhzfDziEyQ3jWSUdHMw+i/2cp6FnDp6XlyE6vs+CNf9veKrNeZ45Oi386TBnFqaCBLmfGAj1OUViuyCy75RSNpm9D0RFvXZ9laDZyXAgMBAAECggEANPO/3H0L25OoBLJrfom5KIaWklj6MVERrQYsZLPiA4BbK0jgNXS6seqhDJHdMNKpCgYMvatgEGCO4CI2Pp2KGF5a6OoZCOEGLYYkEuE9Rk9D/agKRBRitHBUZzMVVXOU0OwPr13HRy9HUv+oR5ZSgAAeOtv8vgheHFXimRiLGR5WEjHLxcCbnQpP0AT7SDYngW3+K2n5JcFe/DhZpo4x6ANPiymWCYAtOonG8qs2L6y8IFTSwcXkHGdNdhb91eyGtyGrslmLsD76QRba5jnaqjZw0B+k8xQ734uoga87XtITdcjVpL51UV2oZdziG/X1c+tLqi+qpK0Hu8JP0v5GgQKBgQDdhLtrtGwOEsNQJd8G61uF+kyMhrJWfFnsNX6TMFOhXPiftP5xh0rRzoTlQt9uLyDNWELtRTc3bEWC/b7oqtvM6mnjysIYkwMoCPq5vjuRU+6+6V2HDl9GFhELrgoxxOqXNum3sUv3ij2bbqYQTCoGpSAHfwkHc1+xqwDwr6If4QKBgQDVqoy4pxhP1ora+on9FWVh7hl7aInb0RrmYvEiZoh8saZLUQmoLZxO19nqDbmv+bcuXxaDpzfa24eAXrdDx+xXKHMhdlEWH47fXjsLWxKaJZU7BV0rKdOm509hOy/VE/llnmP8BDjV4Fjze4NRUHA8hAi+/RqePJE+jXt0XRYrdwKBgE1WxxyubD9pm5lC75/50gVvwwQZDvCVD8whTSTUbY5b6E3SIje+1Yd0w/9LHrjYaWpoE03FqaaG/anjL6EJ7h2YBgpKwwNTaHm00NzCpwdxN1yeG1JI2Uid8auTQunnZ0QOHwFMPEqbkDDRK9dq0A1r30feuWdJh7J/Ep/1ofPhAoGBAK/ozhpoV3fDpmZKxrh6mRFbOdeEZZt4OLFc3DH6QHyIteRkP5Mamgm/ZEVyL2JWMR4YYyzYyv+ApbpmQHOpcUcAomj2RCP2r2Xu6qWawWHvd0E0VVRoBzzuS0g9tk+zNi0XjjG6OCC9p/4tvhuAIidwfNLhBr0oGFxrlyxiRxJZAoGAZJwYh4UQCEBDNQbO/a9RR/EbRWy9gr3BQRYZCtnqhFcY1KU0IeDWOjUjX/HDdOxneD4uQ0DaHDS6+RUL3dMfX9nVSVN6/d7kUJ6MoeBxpe+sIKDrqGzNs0Xg+X6QKZhw/eQ00HP1FwVzKWif5vl1Ii9l233my1sPqiN8xwvVsg0=";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAt3stb3Zew+nNMzj3G/eXZFKJLFhhn35gDCjAouCmc66LenUXyVUs2vYRw3pTdHcLDBvsdVrnztT2vXBU9n46BrgfyzKa1C7imakeZ9hEgaCon5nDIBEEaW5anKTybfW0W2DIv5nkDYUulZNHSsnT9sT3oCDz6ayIoE3YP0cWEbWAAlOEA/yTH8zY5sIpD4Gqq4WumDEbfXNj0RIMkiBXKbhrYMo1jHV8Aup8kj19eg6qKSIE2LRTjWdCTXlLnGSZmBzvKZbpOU3/vQxH5aUIOR8VMZ+Uv7yg6DaIg3xOuwaaoQIPfDCW0x5OtIVF2EfBhgoPot9bOtUXoLOjItW+iwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8081/#/ordersuccess";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8081/#/ordersuccess";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 支付宝网关
	public static String log_path = "C:\\";

    public static String getApp_id() {
        return app_id;
    }

    public static void setApp_id(String app_id) {
        AlipayConfig.app_id = app_id;
    }

    public static String getMerchant_private_key() {
        return merchant_private_key;
    }

    public static void setMerchant_private_key(String merchant_private_key) {
        AlipayConfig.merchant_private_key = merchant_private_key;
    }

    public static String getAlipay_public_key() {
        return alipay_public_key;
    }

    public static void setAlipay_public_key(String alipay_public_key) {
        AlipayConfig.alipay_public_key = alipay_public_key;
    }

    public static String getNotify_url() {
        return notify_url;
    }

    public static void setNotify_url(String notify_url) {
        AlipayConfig.notify_url = notify_url;
    }

    public static String getReturn_url() {
        return return_url;
    }

    public static void setReturn_url(String return_url) {
        AlipayConfig.return_url = return_url;
    }

    public static String getSign_type() {
        return sign_type;
    }

    public static void setSign_type(String sign_type) {
        AlipayConfig.sign_type = sign_type;
    }

    public static String getCharset() {
        return charset;
    }

    public static void setCharset(String charset) {
        AlipayConfig.charset = charset;
    }

    public static String getGatewayUrl() {
        return gatewayUrl;
    }

    public static void setGatewayUrl(String gatewayUrl) {
        AlipayConfig.gatewayUrl = gatewayUrl;
    }

    public static String getLog_path() {
        return log_path;
    }

    public static void setLog_path(String log_path) {
        AlipayConfig.log_path = log_path;
    }

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

