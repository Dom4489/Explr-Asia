package ui;

import model.Hotel;
import model.HotelList;

import java.util.Scanner;

// This class represents the user interface for the application
public class HotelApp {

    private static final String DEFAULT_LIST_NAME = "Hotel list";
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

    // EFFECTS: constructs runHotel
    public HotelApp() {
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
        } else {
            System.out.println("Selection not valid, please try again at a later time");
        }

    }

    // MODIFIES: this
    // EFFECTS: processes the user's input once hotel list has been chosen from the display menu
    private void prcoessListCommand(String option) {
        if (option.equals("view list properties")) {
            this.displayList();
        } else if (option.equals("remove hotel from list")) {
            this.doRemove();
        } else if (option.equals("set list name")) {
            this.doSetListName();
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes each field
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private void init() {
        this.hotelList = new HotelList(DEFAULT_LIST_NAME);
        this.input = new Scanner(System.in);
        this.input.useDelimiter("\n");
        this.gz1 = new Hotel("Langham", 280, "Haizhu");
        this.gz2 = new Hotel("Ritz-carlton", 345, "Tian He");
        this.gz3 = new Hotel("Four Seasons", 378, "Tian He");
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
        System.out.println("Hotels");
        System.out.println("Hotel list");
        System.out.println("quit");
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
        prcoessListCommand(option);
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
            hotelList.addHotelToList(gz1);
        } else if (hotelToAdd.equals("Ritz-carlton")) {
            hotelList.addHotelToList(gz2);
        } else if (hotelToAdd.equals("Four Seasons")) {
            hotelList.addHotelToList(gz3);
        } else {
            System.out.println("Selection not valid please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddBJ(String hotelToAdd) {
        if (hotelToAdd.equals("Ascott Raffles")) {
            hotelList.addHotelToList(bj1);
        } else if (hotelToAdd.equals("Grand Hyatt")) {
            hotelList.addHotelToList(bj2);
        } else if (hotelToAdd.equals("Rosewood")) {
            hotelList.addHotelToList(bj3);
        } else {
            System.out.println("Selection not valid please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddSH(String hotelToAdd) {
        if (hotelToAdd.equals("Shangri-la")) {
            hotelList.addHotelToList(sh1);
        } else if (hotelToAdd.equals("Ritz-carlton")) {
            hotelList.addHotelToList(sh2);
        } else if (hotelToAdd.equals("Grand Kempinski")) {
            hotelList.addHotelToList(sh3);
        } else {
            System.out.println("Selection not valid please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddTJ(String hotelToAdd) {
        if (hotelToAdd.equals("Ritz-carlton")) {
            hotelList.addHotelToList(tj1);
        } else if (hotelToAdd.equals("Mariott")) {
            hotelList.addHotelToList(tj2);
        } else if (hotelToAdd.equals("Crowne Plaza")) {
            hotelList.addHotelToList(tj3);
        } else {
            System.out.println("Selection not valid please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddSZ(String hotelToAdd) {
        if (hotelToAdd.equals("Langham")) {
            hotelList.addHotelToList(sz1);
        } else if (hotelToAdd.equals("Hilton")) {
            hotelList.addHotelToList(sz2);
        } else if (hotelToAdd.equals("Hilton (Sea World)")) {
            hotelList.addHotelToList(sz3);
        } else {
            System.out.println("Selection not valid please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddCD(String hotelToAdd) {
        if (hotelToAdd.equals("Mariott")) {
            hotelList.addHotelToList(cd1);
        } else if (hotelToAdd.equals("Hilton")) {
            hotelList.addHotelToList(cd2);
        } else if (hotelToAdd.equals("Kempinski")) {
            hotelList.addHotelToList(cd3);
        } else {
            System.out.println("Selection not valid please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddCQ(String hotelToAdd) {
        if (hotelToAdd.equals("Niccolo")) {
            hotelList.addHotelToList(cq1);
        } else if (hotelToAdd.equals("Crowne Plaza")) {
            hotelList.addHotelToList(cq2);
        } else if (hotelToAdd.equals("Banyan")) {
            hotelList.addHotelToList(cq3);
        } else {
            System.out.println("Selection not valid please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddDG(String hotelToAdd) {
        if (hotelToAdd.equals("Sheraton")) {
            hotelList.addHotelToList(dg1);
        } else if (hotelToAdd.equals("Mission Hills")) {
            hotelList.addHotelToList(dg2);
        } else if (hotelToAdd.equals("Pullman")) {
            hotelList.addHotelToList(dg3);
        } else {
            System.out.println("Selection not valid please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddSY(String hotelToAdd) {
        if (hotelToAdd.equals("Hilton")) {
            hotelList.addHotelToList(sy1);
        } else if (hotelToAdd.equals("Grand Hyatt")) {
            hotelList.addHotelToList(sy2);
        } else if (hotelToAdd.equals("Conrad")) {
            hotelList.addHotelToList(sy3);
        } else {
            System.out.println("Selection not valid please try again");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds the selected hotel to the user's hotel list
    private void doAddWH(String hotelToAdd) {
        if (hotelToAdd.equals("Grand Plaza")) {
            hotelList.addHotelToList(wh1);
        } else if (hotelToAdd.equals("Intercontinental Wuhan")) {
            hotelList.addHotelToList(wh2);
        } else if (hotelToAdd.equals("Fairmont")) {
            hotelList.addHotelToList(wh3);
        } else {
            System.out.println("Selection not valid please try again");
        }
    }

}
