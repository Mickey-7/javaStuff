package com.example.JavaJSONJackson.JavaObjectToJSON;

import com.example.JavaJSONJackson.domain.Staff;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JacksonExample1 {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Staff staff = createStaff();

        mapper.writeValue(
                new File("C:\\Users\\donat\\Downloads\\JavaJSONJackson\\JavaJSONJackson\\staff.json"),
                staff
        );
        String jsonString = mapper.writeValueAsString(staff);
        System.out.println(jsonString);

        String jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
        System.out.println(jsonInString2);


    }

    private static Staff createStaff() {
        Staff staff = new Staff();
        staff.setName("mkyong");
        staff.setAge(38);
        staff.setPosition(new String[]{
                "Founder",
                "CTO",
                "Writer"
        });
        Map<String, BigDecimal> salary = new HashMap(){{
           put("2010", new BigDecimal(12323142));
           put("2012", new BigDecimal(15342));
           put("2018", new BigDecimal(125453142));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java","pyhton","node","kotlin"));
        return  staff;
    }
}
