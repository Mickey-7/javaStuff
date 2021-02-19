package com.example.NashornShit;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class InvokeJavaMethodsFromJS {

    //this is invoked on InvokeJavaMethodsFromJS.js
    public static String fun1(String name){
        System.out.format("Hi there from Java, %s", name);
        return "greetings form Java";
    }

    //this is invoked on InvokeJavaMethodsFromJS.js
    public static void fun2(Object object){
        System.out.println(object.getClass());
    }

    //create this method to test if the method above is called from InvokeJavaMethodsFromJS.js
    public void nashorn3() throws ScriptException, NoSuchMethodException, FileNotFoundException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        scriptEngine.eval(new FileReader("js/InvokeJavaMethodsFromJS.js"));

    }
}
