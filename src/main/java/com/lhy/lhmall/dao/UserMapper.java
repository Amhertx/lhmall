package com.lhy.lhmall.dao;

import com.lhy.lhmall.entity.User;
import com.lhy.lhmall.util.PageQueryUtil;
import com.lhy.lhmall.util.PageResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 新增用户
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 选择性新增
     * @param user
     * @return
     */
    int insertSelective(User user);

    /**
     * 根据id删除
     * @param userId
     * @return
     */
    int deleteById(Long userId);

    /**
     * 根据用户名查询
     * @param loginName
     * @return
     */
    User selectByLoginName(String loginName);

    /**
     * 根据id查询
     * @param userId
     * @return
     */
    User selectById(Long userId);

    /**
     * 查询登录名和密码
     * @param loginName
     * @param password
     * @return
     */
    User selectByLoginAndPassword(@Param("loginName") String loginName,@Param("password") String password);

    /**
     * 集合查询
     * @param pageQueryUtil
     * @return
     */
    List<User> findUserList(PageQueryUtil pageQueryUtil);

    /**
     * 根据id修改（更新）用户信息
     * @param user
     * @return
     */
    int updateById(User user);

    /**
     *  选择性修改
     * @param user
     * @return
     */
    int updateByIdSelective(User user);

    /**
     * 获取用户数
     * @param pageQueryUtil
     * @return
     */
    int getTotaUsers(PageQueryUtil pageQueryUtil);

    int lockUserBatch(@Param("ids") Integer[] ids, @Param("lockStatus") int lockStatus);
}
