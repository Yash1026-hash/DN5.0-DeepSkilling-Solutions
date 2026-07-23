package com.dn5.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingService service = context.getBean(GreetingService.class);

        System.out.println(service.greet("Yash"));
        System.out.println(service.greet("Spring Developer"));

        SortRunner runner = context.getBean(SortRunner.class);
        runner.runSort();

        context.close();
    }
}
