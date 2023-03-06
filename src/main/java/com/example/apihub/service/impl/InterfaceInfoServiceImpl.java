package com.example.apihub.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.apihub.common.ErrorCode;
import com.example.apihub.exception.BusinessException;
import com.example.apihub.exception.ThrowUtils;
import com.example.apihub.mapper.InterfaceInfoMapper;
import com.example.apihub.model.entity.InterfaceInfo;
import com.example.apihub.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author jayingyoung
* @description 针对表【interface_info(interface infomation)】的数据库操作Service实现
* @createDate 2023-03-05 13:14:50
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService {

	/**
	 * 校验
	 *
	 * @param interfaceInfo
	 * @param add
	 */
	@Override
	public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
		if (interfaceInfo == null) {
			throw new BusinessException(ErrorCode.PARAMS_ERROR);
		}
		String name = interfaceInfo.getName();
		// 创建时，参数不能为空
		if (add) {
			ThrowUtils.throwIf(StringUtils.isAnyBlank(name), ErrorCode.PARAMS_ERROR);
		}
		// 有参数则校验
		if (StringUtils.isNotBlank(name)) {
			throw new BusinessException(ErrorCode.PARAMS_ERROR, "标题过长");
		}
		if (StringUtils.isNotBlank(name) && name.length() < 50) {
			throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
		}
	}

}




