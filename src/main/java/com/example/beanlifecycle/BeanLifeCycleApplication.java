package com.example.beanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BeanLifeCycleApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(BeanLifeCycleApplication.class, args);
        /**
         * 销毁容器
         */
        context.close();
    }
}
