package com.lhy.lhmall.dao;

import com.lhy.lhmall.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper{
    int insert(Admin admin);

    /**
     * 登录方法
     * @param userName
     * @param password
     * @return
     */
    Admin login(@Param("userName") String userName,@Param("password") String password);
    Admin selectById(Integer adminId);
    int updateById(Admin admin);

}
