package com.journey.spring.ioc.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * 地址前缀：
 * classpath:, file:, http://, ftp://
 * Created by zhangyuan on 15/12/26.
 */
public class PatternResolverTest {

    public static void main(String[] args) throws IOException {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //加载WEB-INFO所有类包（及子孙包）下的以jps为后缀的资源
        //classpath* 会扫描所有JAR包及类路径下，classpath只会扫描第一个加载的包下。对分模块打包很有用
        Resource[] resources = resolver.getResources("classpath*:WEB-INF/**/*.jsp");
        for (Resource resource: resources) {
            System.out.println(resource.getDescription());
        }
    }

}
