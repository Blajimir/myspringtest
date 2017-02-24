package ru.myspringtest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.myspringtest.loader.MyClassLoader;
import ru.myspringtest.module.ModuleManager;

/**
 * Created by blajimir on 09.02.2017.
 */
@Configuration
//@ComponentScan
public class AppConfig {

    @Bean
    public MyClassLoader classLoader(){
        MyClassLoader classLoader =  new MyClassLoader(AppConfig.class.getClassLoader());
        return classLoader;
    }

    @Bean
    public ModuleManager moduleManager(){
        ModuleManager moduleManager = new ModuleManager();
        moduleManager.setClassLoader(classLoader());
        return moduleManager;
    }
}
