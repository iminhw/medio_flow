package com.minhw.medioflow.controller;

import com.minhw.medioflow.config.MedioHttpRequestHandler;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


/**
 * @program: medioFlow
 * @description: 视频流
 * @author: MinHw or mz
 * @create: 2022-05-31 23:57
 * RestController注解，相当于@Controller+@ResponseBody两个注解的结合
 **/
@RestController
class MediaController {

    String url = "/Users/mz/Downloads/";

    @Resource
    private MedioHttpRequestHandler medioHttpRequestHandler;

    /**
     * 获取视频
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping("/video")
    public void getPlayResource(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Path path = Paths.get(url + "原神 2022-05-21 13-31-04.mp4");
//        Path path = Paths.get(url+"乔洋,周林枫 - 修得孤独淡寂寞.mp3");
        if (Files.exists(path)) {
            String mimeType = Files.probeContentType(path);
            if (!StringUtils.isEmpty(mimeType)) {
                response.setContentType(mimeType);
            }
            request.setAttribute(MedioHttpRequestHandler.ATTR_FILE, path);
            medioHttpRequestHandler.handleRequest(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        }
    }
}

