package com.acting.actapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.acting.actapiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.acting.actapiclientsdk.utils.SignUtils.genSign;


public class ActApiClient {

    private String accessKey;
    private String secretKey;

    public ActApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    /**
     * 获取请求的hash映射
     * @param body 请求体内容
     * @return 包含请求头参数的哈希映射
     */
    private Map<String, String> getHeaderMap(String body) {
        Map<String, String> map = new HashMap<>();
        map.put("accessKey", accessKey);
        map.put("nonce", RandomUtil.randomNumbers(4));
        map.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        map.put("body",body);
        //秘钥不可以直接被传递
        // map.put("secretKey", secretKey);
        map.put("sign",genSign(body,secretKey));
        return map;
    }

    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post("http://localhost:8123/api/name/", paramMap);
        System.out.println(result);
        return result;
    }


    /**
     * 通过post请求获取用户名
     * @param user 用户对象
     * @return 从服务器获取的用户名
     */
    public String getUserNameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse response = HttpRequest.post("http://localhost:8123/api/name/user")
                //添加请求头
                .addHeaders(getHeaderMap(json))
                //设置请求体
                .body(json)
                //发送请求
                .execute();
        //打印相应状态码
        System.out.println(response.getStatus());
        String result = response.body();
        //打印响应体内容
        System.out.println(result);
        return result;
    }
}
