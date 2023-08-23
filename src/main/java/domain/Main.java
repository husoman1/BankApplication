package domain;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {
         // Process InputJSON as DB
        Database acc = Database.getInstance();
        int input1 = Menu.initApp(); //APP Menu init
        Menu.appFlow(input1,acc); // APP init
    }
}