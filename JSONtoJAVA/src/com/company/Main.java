package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
	// write your code here
        //get json filename
        String path = "C:\\Users\\donat\\Downloads\\JSONtoJAVA\\Person.json";

        JSONParser parser = new JSONParser();
        List fields = new ArrayList();
            Reader reader = new FileReader(path);
            JSONObject jsonObject = new JSONObject();
            jsonObject = (JSONObject) parser.parse(reader);

            for (Object key : jsonObject.keySet()){
                System.out.println(key);
               fields.add(key);
            }

        String filename = new File(path).getName();
        if (filename.contains(".json")){
            String name = filename.replace(".json","");

            File javaFile = new File("C:\\Users\\donat\\Downloads\\JSONtoJAVA\\"+name+".java");
            try {
                FileWriter fileWriter = new FileWriter(javaFile);
                fileWriter.write("public class "+name+"{\n");
                for (int i=0; i < fields.size(); i++){
                    fileWriter.write("\tprivate String "+fields.get(i)+";\n");

                }
                for (int i=0; i < fields.size(); i++){
                    fileWriter.write("\n");
                    fileWriter.write("\tpublic void set"+fields.get(i)+"(String "+fields.get(i)+"){\n");
                    fileWriter.write("\t\tthis."+fields.get(i)+" = "+fields.get(i)+";\n\t}");

                    fileWriter.write("\n\tpublic String get"+fields.get(i)+"(){\n");
                    fileWriter.write("\t\treturn "+fields.get(i)+";\n\t}\n");
                }
                fileWriter.write("\n}");
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
