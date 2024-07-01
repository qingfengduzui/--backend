//package org.example.test_second;
//
//import javafx.application.Application;
//import javafx.stage.Stage;
//import org.example.test_second.utils.HttpUtils;
//
//import org.apache.http.HttpResponse;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public static void main(String[] args) {
//        String host = "https://ali-weather.showapi.com";
//        String path = "/hour24";
//        String method = "GET";
//        String appcode = "591be83713e54f649c3d63248cc17a39";
//        Map<String, String> headers = new HashMap<String, String>();
//        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
//        headers.put("Authorization", "APPCODE " + appcode);
//        Map<String, String> querys = new HashMap<String, String>();
//        querys.put("area", "重庆市沙坪坝区重庆大学虎溪校区");
//        querys.put("areaCode", "areaCode");
//
//
//        try {
//        /**
//         * 重要提示如下:
//         * HttpUtils请从
//         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
//         * 下载
//         *
//         * 相应的依赖请参照
//         * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
//         */
//        HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//        System.out.println(response.toString());
//        //获取response的body
//        //System.out.println(EntityUtils.toString(response.getEntity()));
//        } catch (Exception e) {
//        e.printStackTrace();
//        }
//        }