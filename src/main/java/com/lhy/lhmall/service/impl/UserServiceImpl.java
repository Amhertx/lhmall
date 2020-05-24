package com.lhy.lhmall.service.impl;

import com.lhy.lhmall.common.Constants;
import com.lhy.lhmall.common.ServiceResultEnum;
import com.lhy.lhmall.dao.UserMapper;
import com.lhy.lhmall.entity.User;
import com.lhy.lhmall.service.UserService;
import com.lhy.lhmall.util.BeanUtil;
import com.lhy.lhmall.util.MD5Util;
import com.lhy.lhmall.util.PageQueryUtil;
import com.lhy.lhmall.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageResult getUserPage(PageQueryUtil pageQueryUtil) {
        //查询集合
        List<User> userList = userMapper.findUserList(pageQueryUtil);
        int totaUsers = userMapper.getTotaUsers(pageQueryUtil);
        PageResult pageResult1 = new PageResult(userList,totaUsers,pageQueryUtil.getLimit(),pageQueryUtil.getPage());//工具类
        return pageResult1;
    }

    /**
     * 注册
     * @param loginName
     * @param password
     * @return
     */
    @Override
    public String register(String loginName, String password) {
        if (userMapper.selectByLoginName(loginName) != null) {
            return ServiceResultEnum.SAME_LOGIN_NAME_EXIST.getResult();
        }
        User user = new User();
        user.setLoginName(loginName);
        user.setNickName(loginName);
        //用md5加密
        String md5Encode = MD5Util.MD5Encode(password, "UTF-8");
        user.setPassword(md5Encode);
        //如果新增的用户输入不为空，则返回注册成功
        if (userMapper.insertSelective(user)>0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    /**
     * 登录
     * @param loginName
     * @param password
     * @param httpSession
     * @return
     */
    @Override
    public String login(String loginName, String password, HttpSession httpSession) {
        //调用方法，获取登录名和密码
        User user = userMapper.selectByLoginAndPassword(loginName, password);
        //判断用户是否为空并且session值不为空
        if (user != null && httpSession != null) {
            //判断账号是否封锁
            if (user.getLockedFlag() == 1) {
                return ServiceResultEnum.LOGIN_USER_LOCKED.getResult();
            }
            //昵称过长 影响页面显示，则显示。。
            if (user.getNickName() != null && user.getNickName().length() > 7) {
                String longName = user.getNickName().substring(0, 7) + "...";
                user.setNickName(loginName);
            }
            //成功登录
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.LOGIN_ERROR.getResult();
    }

    /**
     * 修改用户信息
     * @param user
     * @param httpSession
     * @return
     */
    @Override
    public User updateUserInfo(User user, HttpSession httpSession) {
        //获取要修改用户的id
        User user1 = userMapper.selectById(user.getUserId());
        //如果用户不为空
        if (user1 != null) {
            //修改操作
            user1.setNickName(user.getLoginName());
            user1.setAddress(user.getAddress());
            //如果修改后的数据不为空
            if (userMapper.updateByIdSelective(user1) > 0) {
                //创建新的对象存user1的值
                User user2 = new User();
                //获取user1的id
                user1 = userMapper.selectById(user.getUserId());
                //拷贝
                BeanUtil.copyProperties(user1,user2);
                //设置新的属性到session
                httpSession.setAttribute(Constants.MALL_USER_SESSION_KEY,user2);
                return user2;
            }
        }
        return null;
    }

    /**
     * 用户锁定判断
     * @param ids
     * @param lockStatus
     * @return
     */
    @Override
    public Boolean lockUsers(Integer[] ids, int lockStatus) {
        if (ids.length < 1) {
            return false;
        }
        return null;
    }
}
