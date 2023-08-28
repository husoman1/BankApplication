package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSON {

    public void prepareOutJSON(List<Customer> cus){
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            System.out.println(cus.size());
            for (int i = 0; i < cus.size(); i++) {
                System.out.println(cus.get(i).customerID);

            }
            objectMapper.writeValue(new File("src/main/java/org/example/outputJSON"), cus);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
