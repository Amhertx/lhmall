package com.lhy.lhmall.service;

import com.lhy.lhmall.entity.Admin;


public interface AdminService {
    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    Admin login(String userName,String password);

    /**
     * 获取用户信息
     * @param loginUserId
     * @return
     */
    Admin getUserById(Integer loginUserId);

    /**
     * 修改密码
     * @param loginUserId
     * @param originalPassword
     * @param newPassword
     * @return
     */
    Boolean updatePassword(Integer loginUserId,String originalPassword,String newPassword);

    /**
     * 修改用户的名称
     * @param loginUserId
     * @param loingAdmin
     * @param nickName
     * @return
     */
    Boolean updateName(Integer loginUserId,String loingAdmin,String nickName);
}
