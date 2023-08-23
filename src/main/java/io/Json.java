package io;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import domain.Database;
import domain.Customer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Json {
    public static ArrayList<Customer> processInputJSON(){

        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(new File("src/IOJson/inputJSON"), mapper.getTypeFactory().constructCollectionType(List.class, Customer.class));
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void prepareOutJSON(Database cus){
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            System.out.println(cus.instance.size());

            for (int i = 0; i < cus.instance.size(); i++) {
                System.out.println(cus.instance.get(i).getCustomerID());
            }

            objectMapper.writeValue(new File("src/IOJson/outputJSON"), cus);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}