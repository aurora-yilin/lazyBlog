package com.mlw.lazyblog.mapper;

import com.mlw.lazyblog.common.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author oRuol
 * @Date 2020/6/25 10:55
 */
@Mapper
public interface ArticleMapper {
    public int saveArticle(@Param("articleEntity") ArticleEntity articleEntity);
}
