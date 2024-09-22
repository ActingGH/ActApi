package com.yupi.project.service.impl.inner;

import com.acting.actapicommon.model.entity.User;
import com.acting.actapicommon.service.InnerUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.project.common.ErrorCode;
import com.yupi.project.exception.BusinessException;
import com.yupi.project.mapper.UserMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        //参数校验
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        //创建查询条件包装器
        QueryWrapper<User> queryWrappe = new QueryWrapper<>();
        queryWrappe.eq("accessKey", accessKey);
        return userMapper.selectOne(queryWrappe);
    }
}
