package com.dai.mozi.admin.po;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class Cash implements Serializable {
    private Integer id;

    private Double cash;

    private String type;

    private String remark;

    private Integer userId;

    private String userName;

    private Date createTime;

    private Date lastModifyTime;

    private static final long serialVersionUID = 1L;
}