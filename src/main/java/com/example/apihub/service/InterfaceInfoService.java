package com.example.apihub.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.apihubcommon.model.entity.InterfaceInfo;

public interface InterfaceInfoService extends IService<InterfaceInfo> {

	void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
