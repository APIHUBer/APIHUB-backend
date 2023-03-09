package com.example.apihub.model.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * interface infomation
 * @TableName interface_info
 */
@TableName(value ="interface_info")
@Data
public class InterfaceInfo implements Serializable {
    /**
     * primary key
     */
    @TableId(type = IdType.AUTO)
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
     * request parameters
     * @document
     * [
     *  {"name": "username", "type": "string"}
     * ]
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

    /**
     * createTime
     */
    private Date createTime;

    /**
     * updateTime
     */
    private Date updateTime;

    /**
     * isDelete(0-not deleted, 1-deleted)
     */
    @TableLogic
    private Byte isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}