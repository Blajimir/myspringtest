package ru.myspringtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.myspringtest.config.AppConfig;
import ru.myspringtest.loader.MyClassLoader;
import ru.myspringtest.module.Module;
import ru.myspringtest.module.ModuleManager;

/**
 * Created by blajimir on 09.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
        MyClassLoader cl = appCtx.getBean(MyClassLoader.class);
        System.out.println(cl.testURL());
        ModuleManager moduleManager = appCtx.getBean(ModuleManager.class);
        Module module = moduleManager.loadModuleFromClass("D:\\Idea_workspace\\testForLClassLoader\\out\\" +
                "production\\testForLClassLoader");
        module.doSomething();
    }
}
