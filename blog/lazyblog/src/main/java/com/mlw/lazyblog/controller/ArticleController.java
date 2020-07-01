package com.mlw.lazyblog.controller;

import com.mlw.lazyblog.common.ResultCode;
import com.mlw.lazyblog.common.ResultVO;
import com.mlw.lazyblog.entity.ArticleEntity;
import com.mlw.lazyblog.service.ArticleService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author oRuol
 * @Date 2020/7/1 19:28
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @PostMapping("/sava")
    public ResultVO saveArticle(ArticleEntity articleEntity){
        try {
            if(articleService.saveArticle(articleEntity) == 1){
                return new ResultVO(ResultCode.SUCCESS);
            }
            else{
                return new ResultVO(ResultCode.ERROR);
            }
        }catch (DataAccessException dae){
            throw dae;
        }catch (RuntimeException re){
            throw re;
        }
    }
}
