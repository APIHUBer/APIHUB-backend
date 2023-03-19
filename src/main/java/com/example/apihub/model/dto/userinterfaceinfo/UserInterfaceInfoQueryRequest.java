package com.example.apihub.model.dto.userinterfaceinfo;

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
public class UserInterfaceInfoQueryRequest extends PageRequest implements Serializable {

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

    /**
     * 0-normal，1-disable
     */
    private Integer status;
}