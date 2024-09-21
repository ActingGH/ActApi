package com.acting.actapiinterface.controller;


import com.acting.actapiclientsdk.model.User;
import com.acting.actapiclientsdk.utils.SignUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

/**
 * 名称 API
 *
 * @author acting
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/")
    public String getNameByGet(String name) {
        return "GET 你的名字是" + name;
    }

    @PostMapping("/")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
        //从请求头获取参数 TODO 校验参数未完成
        String ak = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        //TODO 从数据库获取ak
        if (!ak.equals("acting")) {
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(nonce) > 10000) {
            throw new RuntimeException("无权限");
        }
        //TODO 从数据库获取用户的sk
        String serverSign = SignUtils.genSign(body, "123456");
        if (!sign.equals(serverSign)) {
            throw new RuntimeException("无权限");
        }
        return "Post 你的名字是" + user.getUsername();
    }


}
