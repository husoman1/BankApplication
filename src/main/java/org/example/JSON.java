package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JSON {

    public void prepareOutJSON(ArrayList<Customer> cus){
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(new File("src/main/java/org/example/outputJSON"), cus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
