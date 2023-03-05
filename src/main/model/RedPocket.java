package model;

import java.util.Random;

// this class represents red pockets in which the use can purchase to test their luck
public class RedPocket {

    private Random rand;
    private static final int UPPERBOUND = 301;
    private int amount;


    // MODIFIES: this
    // EFFECTS: constructs a red pocket with a random amount between $1 - $10 inside
    public RedPocket(int amountInside) {
        rand =  new Random();
        amountInside = rand.nextInt(UPPERBOUND);
        amount = amountInside;
    }


    // EFFECTS: returns the amount of money inside the red pocket
    public int getAmount() {
        return amount;
    }
}
