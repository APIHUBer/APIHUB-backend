package com.example.apihub.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.apihubcommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author jayingyoung
* @description 针对表【user_interface_info(relationship of User calls interface)】的数据库操作Mapper
* @createDate 2023-03-10 11:32:42
* @Entity com.example.apihub.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

	List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




