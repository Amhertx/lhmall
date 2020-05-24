package com.lhy.lhmall.service.impl;

import com.lhy.lhmall.dao.AdminMapper;
import com.lhy.lhmall.entity.Admin;
import com.lhy.lhmall.service.AdminService;
import com.lhy.lhmall.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @Override
    public Admin login(String userName, String password) {
        MD5Util.MD5Encode(password, "UTF_8");
        return adminMapper.login(userName, password);
    }

    /**
     * 获取管理员id
     * @param loginUserId
     * @return
     */
    @Override
    public Admin getUserById(Integer loginUserId) {
        return adminMapper.selectById(loginUserId);
    }

    /**
     * 修改密码
     * @param loginUserId
     * @param originalPassword
     * @param newPassword
     * @return
     */
    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        Admin admin = adminMapper.selectById(loginUserId);
        //当前用户非空才可以进行更改
        if (admin != null) {
            String password = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPwd = MD5Util.MD5Encode(newPassword, "UTF-8");
            //比较原密码是否正确
            if (password.equals(admin.getLoginPassword())) {
                //设置新密码并修改
                admin.setLoginPassword(newPwd);
                if (adminMapper.updateById(admin) > 0) {
                    //修改成功，返回true
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public Boolean updateName(Integer loginUserId, String loingAdmin, String nickName) {
        Admin admin = adminMapper.selectById(loginUserId);
        //当前用户非空才可以更改
        if (admin != null) {
            //设置新名称
            admin.setLoginAdmin(loingAdmin);
            admin.setNickName(nickName);
            if (adminMapper.updateById(admin) > 0) {
                //修改成功发挥true
                return true;
            }
        }
        return false;
    }
}
