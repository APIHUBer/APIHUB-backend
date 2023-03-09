package com.example.apihub.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/zanyuanyang">Zanyuan Yang</a>
 */
@Data
public class InterfaceInfoAddRequest implements Serializable {
    /**
     * 名称
     */
    private String name;

    /**
     * description
     */
    private String description;

    /**
     * api url
     */
    private String url;

    /**
     * request parameters
     */
    private String requestParams;

    /**
     * request Header
     */
    private String requestHeader;

    /**
     * response Header
     */
    private String responseHeader;

    /**
     * request method
     */
    private String method;

}