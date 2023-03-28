package ui;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

// this class runs the graphical user interface program
public class HotelAppGui {

    public static void main(String[] args) {
        try {
            new MenuFrame();
        } catch (FileNotFoundException e) {
            String message = "Unable to run application: file not found";
            JOptionPane.showMessageDialog(null, message);
        }
    }
}
