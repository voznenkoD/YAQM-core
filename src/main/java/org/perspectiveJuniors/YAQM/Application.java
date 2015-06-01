package org.perspectiveJuniors.YAQM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.perspectiveJuniors.YAQM.dao.impl.DaoUser;
import org.perspectiveJuniors.YAQM.dao.impl.GenericDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

/**
 *
 */
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx  = SpringApplication.run(Application.class, args);
        //some code to see list of beans init
//        String[] beanNames = ctx.getBeanDefinitionNames();
//        Arrays.sort(beanNames);
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!Let's inspect the beans provided by Spring Boot:");
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }
    }
}
