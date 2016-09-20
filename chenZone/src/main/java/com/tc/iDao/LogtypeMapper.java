package com.tc.iDao;

import com.tc.model.Logtype;
import com.tc.model.LogtypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogtypeMapper {
    int countByExample(LogtypeExample example);

    int deleteByExample(LogtypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Logtype record);

    int insertSelective(Logtype record);

    List<Logtype> selectByExample(LogtypeExample example);

    Logtype selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Logtype record, @Param("example") LogtypeExample example);

    int updateByExample(@Param("record") Logtype record, @Param("example") LogtypeExample example);

    int updateByPrimaryKeySelective(Logtype record);

    int updateByPrimaryKey(Logtype record);
}