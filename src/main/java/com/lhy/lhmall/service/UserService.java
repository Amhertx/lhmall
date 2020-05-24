package com.lhy.lhmall.service;

import com.lhy.lhmall.entity.User;
import com.lhy.lhmall.util.PageQueryUtil;
import com.lhy.lhmall.util.PageResult;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

public interface UserService {
    /**
     * 分页后台
     * @param pageQueryUtil
     * @return
     */
    PageResult getUserPage(PageQueryUtil pageQueryUtil);

    /**
     * 用户注册
     * @param loginName
     * @param password
     * @return
     */
    String register(String loginName,String password);

    /**
     * 登陆
     * @param loginName
     * @param password
     * @param httpSession
     * @return
     */
    String login(String loginName, String password, HttpSession httpSession);

    /**
     * 修改信息并返回最新用户信息
     * @param user
     * @param httpSession
     * @return
     */
    User updateUserInfo(User user,HttpSession httpSession);

    /**
     * 用户禁用与解禁(0-未锁定 1-已锁定)
     * @param ids
     * @param lockStatus
     * @return
     */
    Boolean lockUsers(Integer[] ids,int lockStatus);
}
