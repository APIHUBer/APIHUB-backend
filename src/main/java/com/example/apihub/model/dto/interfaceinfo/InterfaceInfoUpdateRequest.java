package com.example.apihub.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @author <a href="https://github.com/zanyuanyang">Zanyuan Yang</a>
 */
@Data
public class InterfaceInfoUpdateRequest implements Serializable {

    /**
     * primary key
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * description
     */
    private String description;

    /**
     * request parameters
     */
    private String requestParams;

    /**
     * api url
     */
    private String url;

    /**
     * request Header
     */
    private String requestHeader;

    /**
     * response Header
     */
    private String responseHeader;

    /**
     * api status（0-defaults(close)，1-open）
     */
    private Integer status;

    /**
     * request method
     */
    private String method;

}