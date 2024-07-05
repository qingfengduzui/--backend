package org.example.test_second.service.impl;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.example.test_second.pojo.result;
import org.example.test_second.utils.HttpUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    public ResponseEntity<?> getWeatherInfo() {
        String host = "https://ali-weather.showapi.com";
        String path = "/hour24";
        String method = "GET";
        String appcode = "591be83713e54f649c3d63248cc17a39";
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<>();
        querys.put("area", "重庆市沙坪坝区重庆大学虎溪校区");
        querys.put("areaCode", "areaCode");

        try {

            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);

            // Assuming response.getEntity() returns the response body
            String responseBody = EntityUtils.toString(response.getEntity());
            return ResponseEntity.ok().body(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("异常: " + e.getMessage());
        }
    }
}