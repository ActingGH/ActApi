package com.yupi.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserInterfaceInfoMapper;
import com.yupi.project.model.entity.UserInterfaceInfo;

import com.yupi.project.service.UserInterfaceInfoService;
import org.springframework.stereotype.Service;


@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService {


    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userinterfaceInfo, boolean add) {

        if (userinterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userinterfaceInfo.getInterfaceInfoId() <= 0 || userinterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "接口或用户不存在");
            }
        }
        if (userinterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数小于 0");
        }
    }

    /*

   在这里需要注意的是，由于用户可能会瞬间调用大量接口次数，为了避免统计出错，需要涉及到事务和锁的知识。在这种情况下，如果我们是在分布式环境中运行的，那么可能需要使用分布式锁来保证数据的一致性。

事务是一组操作的集合，要么全部成功，要么全部失败回滚。在这个场景中，我们希望在更新用户接口信息的时候，保证原子性，即要么用户接口信息全部更新成功，要么全部不更新。

锁的作用是为了防止多个线程或进程同时修改同一个数据，造成数据不一致的情况。在分布式环境中，我们需要使用分布式锁来确保在多个节点上对数据的访问是互斥的。

然而，在这里的代码中，并没有实现事务和锁的逻辑。这里只是演示了整体的流程，并没有具体实现细节。所以，如果要在实际项目中应用这个功能，还需要进一步考虑并实现事务和锁的机制，以确保数据的一致性和安全性。
     */
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        //校验参数合法性
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }
}




