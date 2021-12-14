package com.dai.mozi.admin.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author daiyifan
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String userName;

    private String userPhone;

    private String userPsd;

    private String userStatus;

    private Date createTime;

    private Date lastModifyTime;

    private Date lastLoginTime;

    private String userRole;

    private static final long serialVersionUID = 1L;
}
