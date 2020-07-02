package com.mlw.lazyblog.controller;

import com.mlw.lazyblog.common.enums.FileExceptionEnum;
import com.mlw.lazyblog.common.enums.CommonEnum;
import com.mlw.lazyblog.common.vo.ResultVO;
import com.mlw.lazyblog.component.FileProperties;
import com.mlw.lazyblog.common.entity.ArticleEntity;
import com.mlw.lazyblog.service.ArticleService;
import com.mlw.lazyblog.common.vo.FileInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author oRuol
 * @Date 2020/7/1 19:28
 */
@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    FileProperties fileproperties;

    @Resource
    ArticleService articleService;

    @PostMapping("/savaArticleInfo")
    public ResultVO saveArticleInfo(ArticleEntity articleEntity){
        try {
            if(articleService.saveArticle(articleEntity) == 1){
                return new ResultVO(CommonEnum.SUCCESS);
            }
            else{
                return new ResultVO(CommonEnum.ERROR);
            }
        }catch (DataAccessException dae){
            throw dae;
        }catch (RuntimeException re){
            throw re;
        }
    }

    @PostMapping("/saveImage")
    public ResultVO saveimage(@RequestParam("image")MultipartFile multipartFile){
        if (multipartFile.isEmpty()) {
            return new ResultVO(FileExceptionEnum.NOFILE);
        }else{
            String fileName = multipartFile.getOriginalFilename();
            String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
            String randomFilename = UUID.randomUUID().toString()
                    .replace("-", "") + "." + prefix;

            File filelocations = new File(fileproperties.getFileLocations());
            if (!filelocations.exists()) {
                filelocations.mkdirs();
            }

            File image = new File(filelocations, randomFilename);

            //防止随机生成的文件名完全相同
//            while (image.exists()){
//                randomFilename = UUID.randomUUID().toString()
//                        .replace("-", "") + "." + prefix;
//                image = new File(filelocations,randomFilename);
//            }
            log.info("image path:"+image);
            try{
                multipartFile.transferTo(image);
            }catch (IOException e) {
                e.printStackTrace();
                return new ResultVO(FileExceptionEnum.FAILTOFILE);
            }

            FileInfo fileInfo = new FileInfo(randomFilename, fileproperties.getFilePattern());
            return new ResultVO<FileInfo>(CommonEnum.SUCCESS,fileInfo);
        }
    }
}
