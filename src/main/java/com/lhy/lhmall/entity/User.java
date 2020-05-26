package com.lhy.lhmall.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User {
    //用户实体
    private Long userId;//id
    private String nickName;//昵称
    private String loginName;//登录用户名
    private String password;
    private String address;//地址
    private Byte isDeleted;//是否注销
    private Byte lockedFlag;//锁定
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;//注册时间
}
