package com.acting.actapicommon.service;

import com.acting.actapicommon.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author acting
*/
public interface InnerUserInterfaceInfoService  {

    /**
     * 调用接口统计
     * @param interfaceInfoId 接口id
     * @param userId 用户id
     * @return 调用是否成功
     */
    boolean invokeCount(long interfaceInfoId,long userId);

}
