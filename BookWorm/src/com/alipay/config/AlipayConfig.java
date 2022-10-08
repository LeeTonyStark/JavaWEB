package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000121672978";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCCEazb5sto+CNMDRhb1EpfqgNco6ohGH1S5NTMKAK7Quz6mytpCG0DQYcFUtwyFbugoTR+M5Iai15CUEr/LQRPupode9rii4fWBp8kYdZnFRbM5xyozEkjljTUNS3L7LfrB9/QZ+dgoTHu7gFKqMS0vhdpxuzJH1U3XjZjnF/fzqPojtEUlTv/tonWa5sG9t+Oib1KL0XU9H3TUrak+O7VAeUeEezf3Qa3DsuroW7ua+Bep9XVUWqJKhamexzXaki50G77aSsQmbtcClrgS5EWx//aRLAJg+51DxYSAtkv6Y+kg541YAoEKo1zaWsRwGiYKSya99ypbWsBXwawVdGlAgMBAAECggEACknboolfDa6THDDs/FaOi4KnQWywyG1nfGcdbgi8LpPcqvYbOPOxq9BDHeiwAkY10T7vKAxsQi1EB3rSc9zbunLIPgzOA52F4Sgk7nvOudixNQQTAEcogegfxalvNfJDmhPFYHbXlo0ppfytnXo8FQ/0SimyETapRvfs1XRJISraZa4NdOfBZ9GvXxn7vBxgXJRXnjAKvz5RFpv/edVFoDnJ1sGtP3zCYnIW3VZWeUWCnZahsFhTsm6c9ze31bTVF80+6iErwotf5zSQqEI8j5GL6z7ELo9tr2NZKkFyxTca0hMWfbmRNDDmM12TF2uNnNjvfl070uAjTDKV1lSQAQKBgQC/VwQHZlzOws2arbBaGPRTRvraTjiHU3wDFsv5QzDPOZAjuLyDZWKzkwlBAe0mAyNNk0IpjU4vvxRZ0ir+jlMaZ8C+WEQvJZ4wccbCE7XkqVHUDG5DYxhcQLx9Chb9/jErMqTH8oabXRE/rLJtnTO6frspC6bD84nAxGxQn82EFQKBgQCuBhAp7faI6ctYNOlV9kz+Z7iOUOs9wDufoQQRoyCk3df5d7pZnlROcHFULDZ3jj9Lh8evGOaV6ZNloLlAY1RG+wg/SRDwrDXkElb2MMmVbMPTd/oCHYzxE+Blyo7Evd/lkl5p+V1vjbYGdFsEUdndF4awPIPzkb45bm9zQQGrUQKBgGnsyS0zjONl0p7z0rI+KFxF6i+aqA66t+eZ4jfO66F804ADEFGJehfBqZjUcS3fBNc4U6NfN86U8LY89FJSBk2S7JAzmyOipq1Y/1iHwuWgms1SSGSD4oOHzxFF2a6o3x1z/uc2KzCtWBQxDeJC6dUvvXsemSbXlwYhd3k2znZ1AoGAelhi5seY6trLjkDsxvW5XaaYFt4G9MwAXxK5pJi2K5KX85hcGAN7LAZbdpz60gTctQJJve1Yt46WhP2BICZ1Ks30F2IMGdhIrwbBwqW8I2RrLHIN/4y8+QRLX+UPiHwhO+oynHinWvUbQuBs2NWewJR4qdBxyDzvqrrcef/653ECgYAOx6zF5xLRnZRmytUGyVRjAXmuPoQaD5Pkfor2LyJ9obayFbNJG9ZyWhN+qiRoyldtQqc++ye6QnyiP/+XcFS7Ek8nVOAcUN7kynsIz8AbakgM+62XMlOlkAD+F63tBlUpvl6jqkGa4agLejhLTFnm95VzbXcOjf++G0I58gvsoQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAh/GiGdP4Yif6A2p5BUPZoDzNyCZbQunvUi7aysBkFwkDHbvPavhOnLbACS1CoVXbN0bQPVGkouhVLce6/uCgQjdgPqYTFUhBQCzru4q8SMDMeZLUl/bcHu35zQfPJ+ZaZj/u4cywvZ5F/g2U6U//95j41U7RNSWUUNM189l+0AR7iHNhknTU3U9LzdvaRQ/7o2TvEzE/LT4r6stdJV4gqBVOfwH2U0pvQ031hM2j32UcL4Dv+er3+jTILUYzcAOr5fLyflg+k6xQQLzwNM/B2MV0IstmbIWfVcO8yK8DmVuJv5GPjRPE259WWiQcrOzt3zmd+p/TLeYhD+IJsZc7twIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
	public static String notify_url = "http://localhost:8080/UpdateOrderServlet";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
	public static String return_url = "http://localhost:8080/ShowOrderPaySuccessServlet";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
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

