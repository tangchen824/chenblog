package com.tc.iDao;

import com.tc.model.ArticleClob;
import com.tc.model.ArticleClobExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleClobMapper {
    int countByExample(ArticleClobExample example);

    int deleteByExample(ArticleClobExample example);

    int insert(ArticleClob record);

    int insertSelective(ArticleClob record);

    List<ArticleClob> selectByExampleWithBLOBs(ArticleClobExample example);

    List<ArticleClob> selectByExample(ArticleClobExample example);

    int updateByExampleSelective(@Param("record") ArticleClob record, @Param("example") ArticleClobExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticleClob record, @Param("example") ArticleClobExample example);

    int updateByExample(@Param("record") ArticleClob record, @Param("example") ArticleClobExample example);
}