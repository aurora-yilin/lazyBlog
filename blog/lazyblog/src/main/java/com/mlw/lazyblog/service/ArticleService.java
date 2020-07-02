package com.mlw.lazyblog.service;

import com.mlw.lazyblog.common.entity.ArticleEntity;
import com.mlw.lazyblog.mapper.ArticleMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/7/1 19:23
 */
@Service
public class ArticleService {
    @Resource
    ArticleMapper articleMapper;

    public int saveArticle(ArticleEntity articleEntity){
        try {
            return articleMapper.saveArticle(articleEntity);
        }catch (DataAccessException dae){
            throw dae;
        }
    }
}
