package com.example.apihub.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.apihub.common.ErrorCode;
import com.example.apihub.exception.BusinessException;
import com.example.apihub.mapper.UserInterfaceInfoMapper;
import com.example.apihub.service.UserInterfaceInfoService;
import com.example.apihubcommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

/**
* @author jayingyoung
* @description 针对表【user_interface_info(relationship of User calls interface)】的数据库操作Service实现
* @createDate 2023-03-10 11:32:42
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService {

	/**
	 * 校验
	 *
	 * @param userInterfaceInfo
	 * @param add
	 */
	@Override
	public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
		if (userInterfaceInfo == null) {
			throw new BusinessException(ErrorCode.PARAMS_ERROR);
		}

		// 创建时，参数不能为空
		if (add) {
			if(userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0){
				throw new BusinessException(ErrorCode.PARAMS_ERROR, "Interface or user does not exist");
			}
		}
		// 有参数则校验

		if (userInterfaceInfo.getLeftNum() < 0) {
			throw new BusinessException(ErrorCode.PARAMS_ERROR, "Left Num cannot < 0");
		}
	}

	@Override
	public boolean invokeCount(long interfaceInfoId, long userId) {
		// base case
		if(interfaceInfoId <= 0 || userId <= 0){
			throw new BusinessException(ErrorCode.PARAMS_ERROR);
		}
		UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
		updateWrapper.eq("interfaceInfoId", interfaceInfoId);
		updateWrapper.eq("userId", userId);
//		updateWrapper.gt("leftNum", 0);
		updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
		return this.update(updateWrapper);
	}

}




