package com.xiao.web.init;

import com.xiao.web.IndexMain;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Created by sunjinwei on 2018/1/4.
 *
 * @author sunjinwei
 * 使用外部容器运行需要此类
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(IndexMain.class);
    }

}
