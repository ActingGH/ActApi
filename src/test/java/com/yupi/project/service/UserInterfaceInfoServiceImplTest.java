package com.yupi.project.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class UserInterfaceInfoServiceImplTest {
    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Test
    public void invokeCount() {
        boolean b= userInterfaceInfoService.invokeCount(1L,1L);
        //测试用力的期望invokeCount方法返回true
        Assertions.assertTrue(b);
    }


}