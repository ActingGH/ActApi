package com.acting.actapicommon.service;

import com.acting.actapicommon.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 86186
 * @description 针对表【interface_info(接口信息)】的数据库操作Service
 * @createDate 2024-09-20 20:08:40
 */
public interface InnerInterfaceInfoService  {


    /**
     * 数据库中查询接口是否存在
     */
    InterfaceInfo getInterfaceInfo(String path,String method);

}
