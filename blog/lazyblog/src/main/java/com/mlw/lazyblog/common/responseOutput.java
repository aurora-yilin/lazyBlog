package com.mlw.lazyblog.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mlw.lazyblog.common.vo.ResultVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author oRuol
 * @Date 2020/6/23 19:30
 */
public class responseOutput {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 使用jackson将对象转换为json数据
     */
    public static void responJson(ResultVO resultVO, HttpServletResponse response){
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(objectMapper.writeValueAsString(resultVO));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
