package com.dai.common.utils.http;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.util.List;

public class MZHttpUtils {
    public static Object sendGet(String url, List<NameValuePair> nameValuePairList) throws Exception {
        JSONObject jsonObject = null;
        CloseableHttpClient client = null;
        CloseableHttpResponse response = null;
        try {
            client = HttpClients.createDefault();

            URIBuilder uriBuilder = new URIBuilder(url);

            uriBuilder.addParameters(nameValuePairList);

            HttpGet httpGet = new HttpGet(uriBuilder.build());

            httpGet.setHeader(new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8"));

            httpGet.setHeader(new BasicHeader("Accept", "text/plain;charset=utf-8"));

            response = client.execute(httpGet);

            int statusCode = response.getStatusLine().getStatusCode();

            if (200 == statusCode) {
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity, "UTF-8");
                try {
                    jsonObject = JSONObject.parseObject(result);
                    return jsonObject;
                } catch (Exception e) {
                    return result;
                }
            } else {
                System.out.println("报错啦");
            }
        } catch (Exception e) {
            System.out.println("出错啦~~~~");
        } finally {
            response.close();
            client.close();
        }
        return null;
    }
}
