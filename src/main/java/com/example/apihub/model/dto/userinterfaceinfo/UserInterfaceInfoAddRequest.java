package com.example.apihub.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/zanyuanyang">Zanyuan Yang</a>
 */
@Data
public class UserInterfaceInfoAddRequest implements Serializable {
    /**
     * primary key
     */
    private Long id;

    /**
     * user id
     */
    private Long userId;

    /**
     * interface Info id
     */
    private Long interfaceInfoId;

    /**
     * Total number of invoke
     */
    private Integer totalNum;

    /**
     * Remain number of invoke
     */
    private Integer leftNum;

}