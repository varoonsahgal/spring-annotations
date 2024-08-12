package com.intuit.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

// Main application class with configuration
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        // Fetching the BeanSoup bean from the application context
        BeanSoup beanSoup = context.getBean(BeanSoup.class);
        System.out.println("Soup Name: " + beanSoup.getName());
        System.out.println("Contains: " + beanSoup.getKidney().getType());
        System.out.println("And Garbanzo Beans Count: " + beanSoup.getGarbanzoBeans().size());
    }

    // Configuration class for beans

    @Configuration
    static class BeansConfiguration {

        @Bean
        public Kidney kidney() {
            return new Kidney();
        }

        @Bean
        public int garbanzo() {
            return 3;
        }

        @Bean
        public String getSomeStringBean(){
            //let's say you do some fancy String manipulation here...

            return "this is the final result";
        }

        @Bean
        public String getSomeStringBean2(){
            //let's say you do some fancy String manipulation here...

            return "this is the final result";
        }

        @Bean
        public BlackBeans blackBeans() {
            BlackBeans blackBeans = new BlackBeans();
            blackBeans.setKidneyBeans(Arrays.asList(kidney()));
            return blackBeans;
        }

        @Bean
        public BeanSoup beanSoup(Kidney kidney, List<Garbanzo> garbanzoBeans) {
            return new BeanSoup(kidney, garbanzoBeans);
        }
    }

    // Component for Kidney bean
    static class Kidney {
        private String type = "Kidney Bean";

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    // Component for Garbanzo bean
    static class Garbanzo {
        private String type = "Garbanzo Bean";

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    // Component for BlackBeans
    static class BlackBeans {
        private String type = "Black Bean";
        private List<Kidney> kidneyBeans;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Kidney> getKidneyBeans() {
            return kidneyBeans;
        }

        public void setKidneyBeans(List<Kidney> kidneyBeans) {
            this.kidneyBeans = kidneyBeans;
        }
    }

    // Component for BeanSoup with dependencies
}


@Component
class BeanSoup {
    private Application.Kidney kidney;
    private List<Application.Garbanzo> garbanzoBeans;
    private String name;

    @Autowired
    public BeanSoup(Application.Kidney kidney, List<Application.Garbanzo> garbanzoBeans) {
        this.kidney = kidney;
        this.garbanzoBeans = garbanzoBeans;
        this.name = "Delicious Bean Soup";
    }

    public BeanSoup() {
        this.name = "Delicious Bean Soup";
    }

    public Application.Kidney getKidney() {
        return kidney;
    }

    public void setKidney(Application.Kidney kidney) {
        this.kidney = kidney;
    }

    public List<Application.Garbanzo> getGarbanzoBeans() {
        return garbanzoBeans;
    }

    public void setGarbanzoBeans(List<Application.Garbanzo> garbanzoBeans) {
        this.garbanzoBeans = garbanzoBeans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}