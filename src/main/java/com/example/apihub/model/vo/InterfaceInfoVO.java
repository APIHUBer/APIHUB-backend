package com.example.apihub.model.vo;

import com.example.apihub.model.entity.Post;
import com.example.apihubcommon.model.entity.InterfaceInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 帖子视图
 *
 * @author <a href="https://github.com/zanyuanyang">Zanyuan Yang</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class InterfaceInfoVO extends InterfaceInfo implements Serializable{

    private Integer totalNum;

    public static final long serialVersionUID = 1L;

}
