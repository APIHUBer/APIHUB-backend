package com.example.apihub.model.dto.interfaceinfo;

import com.example.apihub.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 *
 * @author <a href="https://github.com/zanyuanyang">Zanyuan Yang</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoQueryRequest extends PageRequest implements Serializable {

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

    /**
     * creator
     */
    private Long userId;
}