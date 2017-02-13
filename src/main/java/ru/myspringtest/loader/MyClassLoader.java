package ru.myspringtest.loader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Благомир on 10.02.2017.
 */
public class MyClassLoader extends ClassLoader{
    public MyClassLoader(ClassLoader parent) {
        super(parent);
    }

    public String testURL(){
        File f = new File("d:\\Idea_workspace\\out\\production\\Idea_workspace\\ru\\hello\\HelloCls.class");
        URL url = null;
        try {
             url = f.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if(url!=null)
            return url.toString();
        return "not url";
    }


}
