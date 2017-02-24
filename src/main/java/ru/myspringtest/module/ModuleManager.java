package ru.myspringtest.module;

import ru.myspringtest.loader.MyClassLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Благомир on 13.02.2017.
 */
public class ModuleManager {
    private MyClassLoader classLoader;

    public MyClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(MyClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public Module loadModuleFromClass(String path) {
        Module module = null;
        try {
            URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{new File(path).toURI().toURL()});
            Class clazz = urlClassLoader.loadClass("forclassloader.SomeModule");
            System.out.println("Canonical name: "+clazz.getCanonicalName());
            module = (Module) clazz.newInstance();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return module;
    }
}
