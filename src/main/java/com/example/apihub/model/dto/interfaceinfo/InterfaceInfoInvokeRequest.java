package com.example.apihub.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * Interface Invoke Request
 *
 * @author <a href="https://github.com/zanyuanyang">Zanyuan Yang</a>
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    /**
     * primary key
     */
    private Long id;

    /**
     * user request parameters
     */
    private String userRequestParams;

    private static final long serialVersionUID = 1L;

}