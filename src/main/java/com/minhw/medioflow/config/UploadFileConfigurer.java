//package com.minhw.medioflow.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * @program: medioFlow
// * @description: 静态资源配置    上次路径目录不能使用中文！！！！！只能英文，否则无法访问
// * @author: MinHw or mz
// * @create: 2022-06-01 00:16
// **/
//@Configuration
//public class UploadFileConfigurer implements WebMvcConfigurer {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/upload/**")
//                .addResourceLocations("file:" + "/");
//    }
//
//
//}
