package com.example.NashornShit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.script.ScriptException;
import java.io.FileNotFoundException;


@SpringBootApplication
public class NashornShitApplication {

	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {

		SpringApplication.run(NashornShitApplication.class, args);

		InvokeJSFileFromJava nashorn1 = new InvokeJSFileFromJava();
		nashorn1.runNashorn1();
		//hello Nashorn

		System.out.println("----------------------------------------------");

		InvokeJSFunctionsFromJava nashorn2 = new InvokeJSFunctionsFromJava();
		nashorn2.nashorn2();
		//Hi there from JavaScript, 2
		//greetings from JavaScript
		//class java.lang.String

		System.out.println("----------------------------------------------");

		InvokeJavaMethodsFromJS nashorn3 = new InvokeJavaMethodsFromJS();
		nashorn3.nashorn3();

		System.out.println("----------------------------------------------");

		LambdaExpressionsAndStreams nashorn4 = new LambdaExpressionsAndStreams();
		nashorn4.nashorn4();

	}

}
