package domain;

import java.util.ArrayList;

import static io.Json.processInputJSON;

public class Database {
    private static Database bankInstance = null;

    public ArrayList<Customer> instance;

    private Database(){
        instance = processInputJSON();
    }

    public static Database getInstance()
    {
        // To ensure only one instance is created
        if (bankInstance == null) {
            bankInstance = new Database();
        }
        return bankInstance;
    }

    public void getConnection() {
        System.out.println("You are now connected to the database.");
    }

}
