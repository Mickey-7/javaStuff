package com.example.NashornShit;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class InvokeJSFileFromJava {

    public void runNashorn1() throws FileNotFoundException, ScriptException {
        ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");
        ee.eval(new FileReader("js/InvokeJSFileFromJava.js"));
    }

    //hello Nashorn
}
