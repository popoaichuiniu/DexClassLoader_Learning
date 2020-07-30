package com.example.dexclassloader_learning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DexClassLoader dexClassLoader=new DexClassLoader("/sdcard/Android/data/com.example.dexclassloader_learning/HelloWorld.dex",null,null,null);
        try {
            Class helloWorld=dexClassLoader.loadClass("HelloWorld");
            Method method=helloWorld.getMethod("print");
            method.invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}