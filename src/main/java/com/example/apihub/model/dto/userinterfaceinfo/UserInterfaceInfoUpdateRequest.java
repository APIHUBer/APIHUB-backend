package com.example.apihub.model.dto.userinterfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @author <a href="https://github.com/zanyuanyang">Zanyuan Yang</a>
 */
@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {

    /**
     * primary key
     */
    private Long id;

    /**
     * Total number of invoke
     */
    private Integer totalNum;

    /**
     * Remain number of invoke
     */
    private Integer leftNum;

    /**
     * 0-normal，1-disable
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

}