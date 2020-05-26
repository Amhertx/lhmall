package com.lhy.lhmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Admin {
    //管理员实体
    private Integer adminId;//管理员id
    private String loginAdmin;//登录名
    private String loginPassword;//登录密码
    private String nickName;//昵称
    private Byte locked;//锁定
}
