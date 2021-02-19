package com.example.NashornShit;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.Date;

public class InvokeJSFunctionsFromJava {

    public void nashorn2() throws FileNotFoundException, ScriptException, NoSuchMethodException {
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        scriptEngine.eval(new FileReader("js/InvokeJSFunctionsFromJava.js"));

        Invocable invocable = (Invocable) scriptEngine;

        Object result = invocable.invokeFunction("fun1", "Peter Parker");
        System.out.println(result);
        System.out.println(result.getClass());

        //for second function on InvokeJSFunctionsFromJava.js file
        invocable.invokeFunction("fun2", new Date());
        invocable.invokeFunction("fun2", LocalDateTime.now());
    }
}
