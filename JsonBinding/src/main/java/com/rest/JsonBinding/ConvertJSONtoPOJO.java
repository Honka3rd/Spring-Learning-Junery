package com.rest.JsonBinding;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.JsonBinding.Entities.Student;

public class ConvertJSONtoPOJO 
{
    public static void main( String[] args )
    {
        try {
        	// create object mapper
        	ObjectMapper mapper = new ObjectMapper();
        	
        	// read JSON file and map/convert to Java POJO
        	// Student stu = mapper.readValue(new File("data/sample-lite.json"), Student.class);
        	Student stu = mapper.readValue(new File("data/sample-full.json"), Student.class);
        	
        	// print object
        	System.out.println(stu);
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
    }
}
