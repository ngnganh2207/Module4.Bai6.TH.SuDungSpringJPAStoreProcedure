package com.codegym.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

//Lớp khởi tạo môi trường dự án, ánh xạ ts các root cấu hình
public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //Chỉ đến lớp cấu hình là AppConfig.class
    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("1");
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("2");
        return new Class[]{};
    }

    //Chỉ định đường dẫn mặc định là "/"
    @Override
    protected String[] getServletMappings() {
        System.out.println("3");
        return new String[]{"/"};
    }

    //Liên quan đến tiếng việt
    @Override
    protected Filter[] getServletFilters(){
        System.out.println("4");
        CharacterEncodingFilter filter= new CharacterEncodingFilter();
        filter.setForceEncoding(true);
        filter.setEncoding("UTF-8");
        return new Filter[]{filter};
    }
}