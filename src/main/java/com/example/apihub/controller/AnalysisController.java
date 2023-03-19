package com.example.apihub.controller;

import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.apihub.annotation.AuthCheck;
import com.example.apihub.common.BaseResponse;
import com.example.apihub.common.ErrorCode;
import com.example.apihub.common.ResultUtils;
import com.example.apihub.exception.BusinessException;
import com.example.apihub.mapper.UserInterfaceInfoMapper;
import com.example.apihub.model.vo.InterfaceInfoVO;
import com.example.apihub.service.InterfaceInfoService;
import com.example.apihubcommon.model.entity.InterfaceInfo;
import com.example.apihubcommon.model.entity.UserInterfaceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.o;

/**
 * Analysis
 * @author jayingyoung
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

	@Resource
	private UserInterfaceInfoMapper userInterfaceInfoMapper;

	@Resource
	private InterfaceInfoService interfaceInfoService;

	@GetMapping("/top/interface/invoke")
	@AuthCheck(mustRole = "admin")
	public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo(){
		List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(3);
		Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjMap = userInterfaceInfoList.stream()
				.collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
		QueryWrapper queryWrapper = new QueryWrapper();
		queryWrapper.in("id", interfaceInfoIdObjMap.keySet());
		List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
		if(CollectionUtils.isEmpty(list)){
			throw new BusinessException(ErrorCode.SYSTEM_ERROR);
		}
		List<InterfaceInfoVO> interfaceInfoVOList = list.stream().map(interfaceInfo -> {
			InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
			BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
			int totalNum = interfaceInfoIdObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
			interfaceInfoVO.setTotalNum(totalNum);
			return interfaceInfoVO;
		}).collect(Collectors.toList());
		return ResultUtils.success(interfaceInfoVOList);
	}
}
