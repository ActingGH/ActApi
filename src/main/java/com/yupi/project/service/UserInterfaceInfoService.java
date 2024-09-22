package com.yupi.project.service;

import com.acting.actapicommon.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {


    public void validUserInterfaceInfo(UserInterfaceInfo userinterfaceInfo, boolean add);

    public boolean invokeCount(long interfaceInfoId, long userId);

}
