package com.example.table;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentsList {
    ArrayList<Students> ArrayStudents;

    public StudentsList(ArrayList<Students> arrayStudents) {
        ArrayStudents = arrayStudents;
    }

    public StudentsList(){
        this.ArrayStudents=new ArrayList<Students>();
    }

    public ArrayList<Students> getArrayStudents() {
        return ArrayStudents;
    }

    public void readJSON(String jsonFileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonBookArray = "";
        Scanner sc = new Scanner(new FileReader(jsonFileName));
        while (sc.hasNextLine()){
            jsonBookArray += sc.nextLine();
        }
        List<Students> list = objectMapper.readValue(jsonBookArray, new TypeReference<List<Students>>(){});
        this.ArrayStudents = new ArrayList<Students>(list);
    }
    public void writingAll(){
        ArrayStudents.stream().forEach(System.out::println);
    }
}
