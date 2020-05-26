package com.lhy.lhmall.dao;

import com.lhy.lhmall.entity.User;
import com.lhy.lhmall.util.PageQueryUtil;
import com.lhy.lhmall.util.PageResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int insert(User user);

    int insertSelective(User user);

    int deleteById(Long userId);

    User selectByLoginName(String loginName);

    User selectById(Long userId);

    User selectByLoginAndPassword(@Param("loginName") String loginName,@Param("password") String password);

    List<User> findUserList(PageQueryUtil pageQueryUtil);

    int updateById(User user);

    int updateByIdSelective(User user);
    int getTotaUsers(PageQueryUtil pageQueryUtil);

    int lockUserBatch(@Param("ids") Integer[] ids, @Param("lockStatus") int lockStatus);
}
