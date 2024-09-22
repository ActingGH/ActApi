package com.acting.actapicommon.service;


import com.acting.actapicommon.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 用户服务
 *
 * @author yupi
 */
public interface InnerUserService{

    /**
     * 数据库查询是否分配秘钥
     * @param accessKey accessKey
     * @return 用户实体类
     */
    User getInvokeUser(String accessKey);

}
