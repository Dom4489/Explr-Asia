package ui;

import model.Hotel;
import model.HotelList;
import model.RedPocket;
import model.Wallet;
import org.json.JSONArray;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

// This class represents the user interface for the application
public class HotelApp {

    private static final String DEFAULT_LIST_NAME = "Hotel list";
    private static final String JSON_LOCATION = "./data/hotellist.json";
    private HotelList hotelList;
    private Scanner input;
    private Hotel gz1;
    private Hotel gz2;
    private Hotel gz3;
    private Hotel bj1;
    private Hotel bj2;
    private Hotel bj3;
    private Hotel sh1;
    private Hotel sh2;
    private Hotel sh3;
    private Hotel tj1;
    private Hotel tj2;
    private Hotel tj3;
    private Hotel sz1;
    private Hotel sz2;
    private Hotel sz3;
    private Hotel cd1;
    private Hotel cd2;
    private Hotel cd3;
    private Hotel cq1;
    private Hotel cq2;
    private Hotel cq3;
    private Hotel dg1;
    private Hotel dg2;
    private Hotel dg3;
    private Hotel sy1;
    private Hotel sy2;
    private Hotel sy3;
    private Hotel wh1;
    private Hotel wh2;
    private Hotel wh3;
    private Wallet w1;
    private RedPocket rp1;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: constructs runHotel
    public HotelApp() throws FileNotFoundException {
        runHotel();
    }

    // MODIFIES: this
    // EFFECTS: runs the hotel application
    private void runHotel() {
        boolean keepGoing = true;
        String command = null;
        this.init();
        this.initBJ();
        this.initSH();
        this.initTJ();
        this.initCD();
        this.initCQ();
        this.initSZ();
        this.initRest();

        while (keepGoing) {
            this.displayMenu();
            command = this.input.next();
            command = command.toLowerCase();
            if (command.equals("quit")) {
                keepGoing = false;
            } else {
                this.processCommand(command);
            }
        }

        System.out.println("\nSee you next time!");
    }

    // MODIFIES: this
    // EFFECTS: processes the first command given by the user
    private void processCommand(String command) {
        if (command.equals("hotels")) {
            this.listDestinations();
        } else if (command.equals("hotel list")) {
            this.listOptions();
        } else if (command.equals("wallet")) {
            this.walletOptions();
        } else if (command.equals("s")) {
            this.saveHotelList();
        } else if (command.equals("l")) {
            this.loadHotelList();
        } else {
            System.out.println("Selection not valid, please try again at a later time");
        }

    }

    private void walletOptions() {
        System.out.println("Enter the action you wish to complete:");
        System.out.println("View funds");
        System.out.println("Deposit funds");
        System.out.println("Test my luck");
        String option = input.next();
        option = option.toLowerCase();
        processWalletCommand(option);
    }

    private void processWalletCommand(String option) {
        if (option.equals("view funds")) {
            System.out.println("Your wallet currently contains: " + w1.getAmount() + " CAD");
        } else if (option.equals("deposit funds")) {
            this.depositFunds();
        } else if (option.equals("test my luck")) {
            this.doRedPocket();
        } else {
            System.out.println("Selection not valid, please try again at a later time");
        }
    }

    private void depositFunds() {
        System.out.println("Enter the amount you would like to deposit:");
        int amount = input.nextInt();
        w1.addAmount(amount);
        System.out.println("Success");
    }

    private void doRedPocket() {
        System.out.println("You are about to pay for a red pocket,");
        System.out.println("A red pocket costs 50 CAD,");
        System.out.println("In return you will receive a random amount or funds from 0 - 350 CAD,");
        System.out.println("Enter: either \"Yes\" to continue or \"No\" to return");
        String selection = input.next();
        selection = selection.toLowerCase();
        gamble(selection);
    }

    private void gamble(String selection) {
        if (selection.equals("yes") && w1.getAmount() >= 50) {
            w1.subAmount(50);
            rp1 = new RedPocket(1);
            int amount = rp1.getAmount();
            w1.addAmount(amount);
            System.out.println("Previous amount: " + (w1.getAmount() - amount + 50) + " CAD");
            System.out.println("Congrats! You received: " + amount + " CAD");
            System.out.println("Current amount: " + w1.getAmount() + " CAD");
        } else {
            System.out.println("Red pocket not purchased");
        }
    }

    // MODIFIES: this
    // EFFECTS: processes the user's input once hotel list has been chosen from the display menu
    private void processListCommand(String option) {
        if (option.equals("view list properties")) {
            this.displayList();
        } else if (option.equals("remove hotel from list")) {
            this.doRemove();
        } else if (option.equals("set list name")) {
            this.doSetListName();
        } else {
            System.out.println("Selection not valid, please try again at a later time");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes each field
    private void init() {
        this.hotelList = new HotelList(DEFAULT_LIST_NAME);
        this.input = new Scanner(System.in);
        this.input.useDelimiter("\n");
        this.w1 = new Wallet(150);
        this.gz1 = new Hotel("Langham", 280, "Haizhu");
        this.gz2 = new Hotel("Ritz-carlton", 345, "Tian He");
        this.gz3 = new Hotel("Four Seasons", 378, "Tian He");
        this.jsonWriter = new JsonWriter(JSON_LOCATION);
        this.jsonReader = new JsonReader(JSON_LOCATION);
    }

    private void initBJ() {
        this.bj1 = new Hotel("Ascott Raffles", 251, "Dongzhimen");
        this.bj2 = new Hotel("Grand Hyatt", 334, "Dongcheng");
        this.bj3 = new Hotel("Rosewood", 445, "Chaoyangmen Outer St");
    }

    private void initSH() {
        this.sh1 = new Hotel("Shangri-la", 340, "Pu-dong");
        this.sh2 = new Hotel("Ritz-carlton", 368, "Pu-dong");
        this.sh3 = new Hotel("Grand Kempinski", 176, "Pu-dong");
    }

    private void initTJ() {
        this.tj1 = new Hotel("Ritz-carlton", 225, "Dagubei");
        this.tj2 = new Hotel("Mariott", 100, "Tian Jin Zhi Yan");
        this.tj3 = new Hotel("Crowne Plaza", 110, "Dongli");
    }

    private void initSZ() {
        this.sz1 = new Hotel("Langham", 203, "Shenan");
        this.sz2 = new Hotel("Hilton", 183, "Fu Tian");
        this.sz3 = new Hotel("Hilton (Sea World)", 183, "Shekou");
    }

    private void initCD() {
        this.cd1 = new Hotel("Mariott", 134, "Chenghua");
        this.cd2 = new Hotel("Hilton", 129, "Ju Wei Jiu");
        this.cd3 = new Hotel("Kempinski", 184, "Wangjiang Pavilion Park");
    }

    private void initCQ() {
        this.cq1 = new Hotel("Niccolo", 216, "Guojin Centre");
        this.cq2 = new Hotel("Crowne Plaza", 116, "Long Hua");
        this.cq3 = new Hotel("Banyan", 358, "Beibei");
    }

    private void initRest() {
        this.dg1 = new Hotel("Sheraton", 99, "Fukang");
        this.dg2 = new Hotel("Mission Hills", 124, "Lin Pin");
        this.dg3 = new Hotel("Pullman", 126, "Huangqi Square");
        this.sy1 = new Hotel("Hilton", 115, "Shenshui");
        this.sy2 = new Hotel("Grand Hyatt", 197, "Liao Ning");
        this.sy3 = new Hotel("Conrad", 186, "Liao Ning");
        this.wh1 = new Hotel("Grand Plaza", 101, "Development Zone");
        this.wh2 = new Hotel("Intercontinental Wuhan", 111, "Boulevard");
        this.wh3 = new Hotel("Fairmont", 268, "Jianghan");
    }

    // EFFECTS: displays the first set of options presented to the user
    private void displayMenu() {
        System.out.println("\nPlease select from the following:");
        System.out.println("\tHotels");
        System.out.println("\tHotel list");
        System.out.println("\tWallet");
        System.out.println("\tS -> save Hotel list to file");
        System.out.println("\tL -> load Hotel list from file");
        System.out.println("\tquit");
    }

    // MODIFIES: this
    // EFFECTS: displays the options once hotel list has been selected from the display menu
    private void listOptions() {
        System.out.println("Enter the action you wish to complete:");
        System.out.println("view list properties");
        System.out.println("remove hotel from list");
        System.out.println("set list name");
        String option = input.next();
        option = option.toLowerCase();
        processListCommand(option);
    }

    // EFFECTS: Displays the contents of a user's hotel list
    private void displayList() {
        System.out.println(hotelList.getListName() + ":");
        System.out.println(hotelList.getHotelListNames());
        System.out.println("Locations: " + hotelList.getHotelLocations());
        System.out.println("Total price: " + hotelList.getTotalHotelPrices());
        System.out.println("Total hotels: " + hotelList.length());
        System.out.println("List full: " + hotelList.listFull() + ", " + "List empty: " + hotelList.listEmpty());
    }

    // MODIFIES: this
    // EFFECTS: removes the first hotel in the list with the name given by the user
    private void doRemove() {
        System.out.println("Enter the name of the hotel you wish to remove");
        String remove = input.next();
        hotelList.removeHotelFromList(remove);
    }

    // MODIFIES: this
    // EFFECTS: sets the name of the user's hotel list
    private void doSetListName() {
        System.out.println("Enter the name in which you want to name your list");
        String listName = input.next();
        hotelList.setListName(listName);
    }

    // MODIFIES: this
    // EFFECTS: prompts the user to enter a supported location
    private void listDestinations() {
        System.out.println("\nEnter your desired location from the list of supported locations:");
        String location = input.next();
        location = location.toLowerCase();
        displayHotels(location);
    }

    // MODIFIES: this
    // EFFECTS: processes the user's input from the listDestinations method and displays a list of available hotels
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void displayHotels(String place) {
        if (place.equals("guangzhou")) {
            System.out.println("Enter the name of the hotel you wish to add");
            System.out.println(gz1.getName() + " Price: " + gz1.getPricePerNight() + " Location: " + gz1.getLocation());
            System.out.println(gz2.getName() + " Price: " + gz2.getPricePerNight() + " Location: " + gz2.getLocation());
            System.out.println(gz3.getName() + " Price: " + gz3.getPricePerNight() + " Location: " + gz3.getLocation());
            String hotelToAdd = input.next();
            doAddGZ(hotelToAdd);
        } else if (place.equals("beijing")) {
            System.out.println("Enter the name of the hotel you wish to add");
            System.out.println(bj1.getName() + " Price: " + bj1.getPricePerNight() + " Location: " + bj1.getLocation());
            System.out.println(bj2.getName() + " Price: " + bj2.getPricePerNight() + " Location: " + bj2.getLocation());
            System.out.println(bj3.getName() + " Price: " + bj3.getPricePerNight() + " Location: " + bj3.getLocation());
            String hotelToAdd = input.next();
            doAddBJ(hotelToAdd);
        } else if (place.equals("shanghai")) {
            System.out.println("Enter the name of the hotel you wish to add");
            System.out.println(sh1.getName() + " Price: " + sh1.getPricePerNight() + " Location: " + sh1.getLocation());
            System.out.println(sh2.getName() + " Price: " + sh2.getPricePerNight() + " Location: " + sh2.getLocation());
            System.out.println(sh3.getName() + " Price: " + sh3.getPricePerNight() + " Location: " + sh3.getLocation());
            String hotelToAdd = input.next();
            doAddSH(hotelToAdd);
        } else if (place.equals("tianjin")) {
            System.out.println("Enter the name of the hotel you wish to add");
            System.out.println(tj1.getName() + " Price: " + tj1.getPricePerNight() + " Location: " + tj1.getLocation());
            System.out.println(tj2.getName() + " Price: " + tj2.getPricePerNight() + " Location: " + tj2.getLocation());
            System.out.println(tj3.getName() + " Price: " + tj3.getPricePerNight() + " Location: " + tj3.getLocation());
            String hotelToAdd = input.next();
            doAddTJ(hotelToAdd);
        } else if (place.equals("shenzhen")) {
            System.out.println("Enter the name of the hotel you wish to add");
            System.out.println(sz1.getName() + " Price: " + sz1.getPricePerNight() + " Location: " + sz1.getLocation());
            System.out.println(sz2.getName() + " Price: " + sz2.getPricePerNight() + " Location: " + sz2.getLocation());
            System.out.println(sz3.getName() + " Price: " + sz3.getPricePerNight() + " Location: " + sz3.getLocation());
            String hotelToAdd = input.next();
            doAddSZ(hotelToAdd);
        } else if (place.equals("chengdu")) {
            System.out.println("Enter the name of the hotel you wish to add");
            System.out.println(cd1.getName() + " Price: " + cd1.getPricePerNight() + " Location: " + cd1.getLocation());
            System.out.println(cd2.getName() + " Price: " + cd2.getPricePerNight() + " Location: " + cd2.getLocation());
            System.out.println(cd3.getName() + " Price: " + cd3.getPricePerNight() + " Location: " + cd3.getLocation());
            String hotelToAdd = input.next();
            doAddCD(hotelToAdd);
        } else if (place.equals("chongqing")) {
            System.out.println("Enter the name of the hotel you wish to add");
            System.out.println(cq1.getName() + " Price: " + cq1.getPricePerNight() + " Location: " + cq1.getLocation());
            System.out.println(cq2.getName() + " Price: " + cq2.getPricePerNight() + " Location: " + cq2.getLocation());
            System.out.println(cq3.getName() + " Price: " + cq3.getPricePerNight() + " Location: " + cq3.getLocation());
            String hotelToAdd = input.next();
            doAddCQ(hotelToAdd);
        } else if (place.equals("dongguan")) {
            System.out.println("Enter the name of the hotel you wish to add");
            System.out.println(dg1.getName() + " Price: " + dg1.getPricePerNight() + " Location: " + dg1.getLocation());
            System.out.println(dg2.getName() + " Price: " + dg2.getPricePerNight() + " Location: " + dg2.getLocation());
            System.out.println(dg3.getName() + " Price: " + dg3.getPricePerNight() + " Location: " + dg3.getLocation());
            String hotelToAdd = input.next();
            doAddDG(hotelToAdd);
        } else if (place.equals("shenyang")) {
            System.out.println("Enter the name of the hotel you wish to add");
            System.out.println(sy1.getName() + " Price: " + sy1.getPricePerNight() + " Location: " + sy1.getLocation());
            System.out.println(sy2.getName() + " Price: " + sy2.getPricePerNight() + " Location: " + sy2.getLocation());
            System.out.println(sy3.getName() + " Price: " + sy3.getPricePerNight() + " Location: " + sy3.getLocation());
            String hotelToAdd = input.next();
            doAddSY(hotelToAdd);
        } else if (place.equals("wuhan")) {
            System.out.println("Enter the name of the hotel you wish to add");
            System.out.println(wh1.getName() + " Price: " + wh1.getPricePerNight() + " Location: " + wh1.getLocation());
            System.out.println(wh2.getName() + " Price: " + wh2.getPricePerNight() + " Location: " + wh2.getLocation());
            System.out.println(wh3.getName() + " Price: " + wh3.getPricePerNight() + " Location: " + wh3.getLocation());
            String hotelToAdd = input.next();
            doAddWH(hotelToAdd);
        } else {
            System.out.println("Selection not valid");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddGZ(String hotelToAdd) {
        if (hotelToAdd.equals("Langham")) {
            if (w1.getAmount() >= gz1.getPricePerNight()) {
                hotelList.addHotelToList(gz1);
                w1.subAmount(gz1.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Ritz-carlton")) {
            if (w1.getAmount() >= gz2.getPricePerNight()) {
                hotelList.addHotelToList(gz2);
                w1.subAmount(gz2.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Four Seasons")) {
            if (w1.getAmount() >= gz3.getPricePerNight()) {
                hotelList.addHotelToList(gz3);
                w1.subAmount(gz3.getPricePerNight());
            }
        } else {
            System.out.println("The previous command did not work: invalid choice or insufficient funds");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddBJ(String hotelToAdd) {
        if (hotelToAdd.equals("Ascott Raffles")) {
            if (w1.getAmount() >= bj1.getPricePerNight()) {
                hotelList.addHotelToList(bj1);
                w1.subAmount(bj1.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Grand Hyatt")) {
            if (w1.getAmount() >= bj2.getPricePerNight()) {
                hotelList.addHotelToList(bj2);
                w1.subAmount(bj2.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Rosewood")) {
            if (w1.getAmount() >= bj3.getPricePerNight()) {
                hotelList.addHotelToList(bj3);
                w1.subAmount(bj3.getPricePerNight());
            }
        } else {
            System.out.println("The previous command did not work: invalid choice or insufficient funds");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddSH(String hotelToAdd) {
        if (hotelToAdd.equals("Shangri-la")) {
            if (w1.getAmount() >= sh1.getPricePerNight()) {
                hotelList.addHotelToList(sh1);
                w1.subAmount(sh1.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Ritz-carlton")) {
            if (w1.getAmount() >= sh2.getPricePerNight()) {
                hotelList.addHotelToList(sh2);
                w1.subAmount(sh2.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Grand Kempinski")) {
            if (w1.getAmount() >= sh3.getPricePerNight()) {
                hotelList.addHotelToList(sh3);
                w1.subAmount(sh3.getPricePerNight());
            }
        } else {
            System.out.println("The previous command did not work: invalid choice or insufficient funds");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddTJ(String hotelToAdd) {
        if (hotelToAdd.equals("Ritz-carlton")) {
            if (w1.getAmount() >= tj1.getPricePerNight()) {
                hotelList.addHotelToList(tj1);
                w1.subAmount(tj1.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Mariott")) {
            if (w1.getAmount() >= tj2.getPricePerNight()) {
                hotelList.addHotelToList(tj2);
                w1.subAmount(tj2.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Crowne Plaza")) {
            if (w1.getAmount() >= tj3.getPricePerNight()) {
                hotelList.addHotelToList(tj3);
                w1.subAmount(tj3.getPricePerNight());
            }
        } else {
            System.out.println("The previous command did not work: invalid choice or insufficient funds");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddSZ(String hotelToAdd) {
        if (hotelToAdd.equals("Langham")) {
            if (w1.getAmount() >= sz1.getPricePerNight()) {
                hotelList.addHotelToList(sz1);
                w1.subAmount(sz1.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Hilton")) {
            if (w1.getAmount() >= sz2.getPricePerNight()) {
                hotelList.addHotelToList(sz2);
                w1.subAmount(sz2.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Hilton (Sea World)")) {
            if (w1.getAmount() >= sz3.getPricePerNight()) {
                hotelList.addHotelToList(sz3);
                w1.subAmount(sz3.getPricePerNight());
            }
        } else {
            System.out.println("The previous command did not work: invalid choice or insufficient funds");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddCD(String hotelToAdd) {
        if (hotelToAdd.equals("Mariott")) {
            if (w1.getAmount() >= cd1.getPricePerNight()) {
                hotelList.addHotelToList(cd1);
                w1.subAmount(cd1.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Hilton")) {
            if (w1.getAmount() >= cd2.getPricePerNight()) {
                hotelList.addHotelToList(cd2);
                w1.subAmount(cd2.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Kempinski")) {
            if (w1.getAmount() >= cd3.getPricePerNight()) {
                hotelList.addHotelToList(cd3);
                w1.subAmount(cd3.getPricePerNight());
            }
        } else {
            System.out.println("The previous command did not work: invalid choice or insufficient funds");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddCQ(String hotelToAdd) {
        if (hotelToAdd.equals("Niccolo")) {
            if (w1.getAmount() >= cq1.getPricePerNight()) {
                hotelList.addHotelToList(cq1);
                w1.subAmount(cq1.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Crowne Plaza")) {
            if (w1.getAmount() >= cq2.getPricePerNight()) {
                hotelList.addHotelToList(cq2);
                w1.subAmount(cq2.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Banyan")) {
            if (w1.getAmount() >= cq3.getPricePerNight()) {
                hotelList.addHotelToList(cq3);
                w1.subAmount(cq3.getPricePerNight());
            }
        } else {
            System.out.println("The previous command did not work: invalid choice or insufficient funds");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddDG(String hotelToAdd) {
        if (hotelToAdd.equals("Sheraton")) {
            if (w1.getAmount() >= dg1.getPricePerNight()) {
                hotelList.addHotelToList(dg1);
                w1.subAmount(dg1.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Mission Hills")) {
            if (w1.getAmount() >= dg2.getPricePerNight()) {
                hotelList.addHotelToList(dg2);
                w1.subAmount(dg2.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Pullman")) {
            if (w1.getAmount() >= dg3.getPricePerNight()) {
                hotelList.addHotelToList(dg3);
                w1.subAmount(dg3.getPricePerNight());
            }
        } else {
            System.out.println("The previous command did not work: invalid choice or insufficient funds");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddSY(String hotelToAdd) {
        if (hotelToAdd.equals("Hilton")) {
            if (w1.getAmount() >= sy1.getPricePerNight()) {
                hotelList.addHotelToList(sy1);
                w1.subAmount(sy1.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Grand Hyatt")) {
            if (w1.getAmount() >= sy2.getPricePerNight()) {
                hotelList.addHotelToList(sy2);
                w1.subAmount(sy2.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Conrad")) {
            if (w1.getAmount() >= sy3.getPricePerNight()) {
                hotelList.addHotelToList(sy3);
                w1.subAmount(sy3.getPricePerNight());
            }
        } else {
            System.out.println("The previous command did not work: invalid choice or insufficient funds");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddWH(String hotelToAdd) {
        if (hotelToAdd.equals("Grand Plaza")) {
            if (w1.getAmount() >= wh1.getPricePerNight()) {
                hotelList.addHotelToList(wh1);
                w1.subAmount(wh1.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Intercontinental Wuhan")) {
            if (w1.getAmount() >= wh2.getPricePerNight()) {
                hotelList.addHotelToList(wh2);
                w1.subAmount(wh2.getPricePerNight());
            }
        } else if (hotelToAdd.equals("Fairmont")) {
            if (w1.getAmount() >= wh3.getPricePerNight()) {
                hotelList.addHotelToList(wh3);
                w1.subAmount(wh3.getPricePerNight());
            }
        } else {
            System.out.println("The previous command did not work: invalid choice or insufficient funds");
        }
    }

    // EFFECTS: saves the hotelList to file
    private void saveHotelList() {
        try {
            jsonWriter.open();
            jsonWriter.write(hotelList);
            jsonWriter.close();
            System.out.println("Saved " + hotelList.getListName() + " to " + JSON_LOCATION);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_LOCATION);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads Hotel list from file
    private void loadHotelList() {
        try {
            hotelList = jsonReader.read();
            System.out.println("Loaded " + hotelList.getListName() + " from " + JSON_LOCATION);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_LOCATION);
        }
    }

}
