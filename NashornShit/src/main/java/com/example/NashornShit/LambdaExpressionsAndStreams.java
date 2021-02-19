package com.example.NashornShit;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LambdaExpressionsAndStreams {
    //create this method to test if the method above is called from InvokeJavaMethodsFromJS.js
    public void nashorn4() throws ScriptException, NoSuchMethodException, FileNotFoundException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        scriptEngine.eval(new FileReader("js/LambdaExpressionsAndStreams.js"));

    }
}
