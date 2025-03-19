package com.ohgiraffers.section03.componentscan.subsection01.java;

// Configuration Metadata 설정 방법
// 1. MXL <bean>
// 2. java @Bean
// 3. @Component

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ConfigurationContext.class);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : beanNames){
            System.out.println("beanName: " + beanName);
        }
    }

}
