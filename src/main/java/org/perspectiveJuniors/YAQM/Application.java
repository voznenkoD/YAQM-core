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
    private static void bashCommand(String ...vararg) throws IOException,InterruptedException{
                // указываем в конструкторе ProcessBuilder,
                // что нужно запустить программу с параметрами
                ProcessBuilder procBuilder = new ProcessBuilder(vararg);
                // перенаправляем стандартный поток ошибок на
                // стандартный вывод
                procBuilder.redirectErrorStream(true);
                // запуск программы
                Process process = procBuilder.start();
                // читаем стандартный поток вывода
                // и выводим на экран
                InputStream stdout = process.getInputStream();
                InputStreamReader isrStdout = new InputStreamReader(stdout);
                BufferedReader brStdout = new BufferedReader(isrStdout);

                String line = null;
                while((line = brStdout.readLine()) != null) {
                    System.out.println(line);
                }
                // ждем пока завершится вызванная программа
                // и сохраняем код, с которым она завершилась в
                // в переменную exitVal
                int exitVal = process.waitFor();

    }
    public static void main(String[] args) {
        String login="yaqm";
        String password="yaqm";
        String db="yaqm";
        String query="";
        query+="CREATE DATABASE "+db+"; ";
        query+="CREATE USER "+login+"; ";
        query+="grant all on "+db+".* to '"+login+"' identified by '"+password+"'; ";
        try{
            bashCommand("mysql", "-u","root","-proot","-e",query);
        }
        catch (Exception e){
            System.out.println(e);
        }
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
