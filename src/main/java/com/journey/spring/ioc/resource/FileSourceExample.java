package com.journey.spring.ioc.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;

/**
 * Spring的访问资源接口ReSource
 * Created by zhangyuan on 15/12/24.
 */
public class FileSourceExample {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/zhangyuan/IdeaProjects/spring_test/target/classes/" +
                "WEB-INF/jsp/login.jsp";
        //使用系统文件路径加载文件
        Resource resource1 = new FileSystemResource(filePath);
        //使用类路径加载文件
        Resource resource2 = new ClassPathResource("WEB-INF/jsp/login.jsp");

        System.out.println("resource1: " + resource1.getFilename());
        System.out.println("resource2: " + resource2.getFilename());

        //对资源进行编码
        EncodedResource encodedResource = new EncodedResource(resource1, "UTF-8");
        String content = FileCopyUtils.copyToString(encodedResource.getReader());
        System.out.println("file content: \n" + content);

    }

}
