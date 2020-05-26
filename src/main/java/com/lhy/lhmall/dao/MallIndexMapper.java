package com.lhy.lhmall.dao;

import com.lhy.lhmall.entity.MallIndex;
import com.lhy.lhmall.util.PageQueryUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MallIndexMapper {
    int deleteById(Long configId);

    int insert(MallIndex mallIndex);

    int insertSelective(MallIndex mallIndex);
    MallIndex selectById(Long configId);

    int updateById(MallIndex mallIndex);
    int updateByIdSelective(MallIndex mallIndex);
    List<MallIndex> findMallIndexList(PageQueryUtil pageQueryUtil);

    int getTotalMallIndex(PageQueryUtil pageQueryUtil);

    int deleteBatch(Long[] ids);
    List<MallIndex> findMallIndexByTypeAndNum(@Param("configType") int configType,@Param("number") int number);
}
