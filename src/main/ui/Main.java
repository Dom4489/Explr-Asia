package ui;

import java.io.FileNotFoundException;

// this class runs the program
public class Main {
    public static void main(String[] args) {
        try {
            new HotelApp();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
