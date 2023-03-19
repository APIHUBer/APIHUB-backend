package com.example.apihub.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.apihub.common.ErrorCode;
import com.example.apihub.exception.BusinessException;
import com.example.apihub.mapper.UserMapper;
import com.example.apihubcommon.model.entity.User;
import com.example.apihubcommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User getInvokeUser(String accessKey) {
		if(StringUtils.isAnyBlank(accessKey)){
			throw new BusinessException(ErrorCode.PARAMS_ERROR);
		}
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("accessKey", accessKey);
		return userMapper.selectOne(queryWrapper);
	}
}
