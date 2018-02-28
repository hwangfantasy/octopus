package com.hwangfantasy.util;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


/**
 * @author hwangfantasy
 */
public class HttpUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * http请求连接超时时间
     */
    private static int httpConnectionTimeout = 5000;

    /**
     * http请求数据读取等待时间
     */
    private static int httpTimeout = 10000;

    public static String get(String url, Map<String, Object> params) {
        try {
            HttpClientBuilder httpClientBuilder = HttpClients.custom();
            String param = "";
            if (params != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("?");
                for (String key : params.keySet()) {
                    stringBuilder.append(key)
                            .append("=")
                            .append(params.get(key))
                            .append("&");
                }
                String temp = stringBuilder.toString();
                param = temp.substring(0, temp.length() - 1);
            }
            HttpGet httpGet = new HttpGet(url + param);
            httpGet.setConfig(RequestConfig.custom()
                    .setConnectionRequestTimeout(httpConnectionTimeout)
                    .setConnectTimeout(httpConnectionTimeout)
                    .setSocketTimeout(httpTimeout)
                    .build());
            try (CloseableHttpClient httpclient = httpClientBuilder.build()) {
                try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    logger.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, params.toString(), responseString);
                    return responseString;
                }
            } finally {
                httpGet.releaseConnection();
            }
        } catch (Exception e) {
            logger.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, params.toString(), e.getMessage());
            return null;
        }
    }

    public static String post(String url, String requestStr) {
        try {
            HttpClientBuilder httpClientBuilder = HttpClients.custom();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setConfig(RequestConfig.custom()
                    .setConnectionRequestTimeout(httpConnectionTimeout)
                    .setConnectTimeout(httpConnectionTimeout)
                    .setSocketTimeout(httpTimeout)
                    .build());
            try (CloseableHttpClient httpclient = httpClientBuilder.build()) {
                httpPost.setEntity(new StringEntity(new String(requestStr.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1)));
                try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
                    String responseString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                    logger.info("\n【请求地址】：{}\n【请求数据】：{}\n【响应数据】：{}", url, requestStr, responseString);
                    return responseString;
                }
            } finally {
                httpPost.releaseConnection();
            }
        } catch (Exception e) {
            logger.error("\n【请求地址】：{}\n【请求数据】：{}\n【异常信息】：{}", url, requestStr, e.getMessage());
            return null;
        }
    }
}
