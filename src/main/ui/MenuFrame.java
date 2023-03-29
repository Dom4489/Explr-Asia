package ui;

import model.Hotel;
import model.HotelList;
import model.RedPocket;
import model.Wallet;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

// This class represents the graphical user interface for the application

public class MenuFrame extends JFrame implements ActionListener {
    private static final String DEFAULT_LIST_NAME = "Hotel list";
    private static final String JSON_LOCATION = "./data/hotellist.json";
    private static final String JSON_LOCATION_WALLET = "./data/wallet.json";
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
    private JsonWriter jsonWriter2;
    private JsonReader jsonReader2;
    private static final int X_DIMENSION = 800;
    private static final int Y_DIMENSION = 800;
    public static final String TITLE_NAME = "ExplrAsia";
    private static final Color BACKGROUND = Color.DARK_GRAY;
    private JLabel label;
    private JButton hotelListBttn = new JButton("Your Hotel List");
    private JButton save = new JButton("Save");
    private JButton load = new JButton("Load");
    private JButton search = new JButton("Search");
    private JButton walletGui = new JButton("Wallet");
    private JPanel image = new JPanel();
    private JPanel searchBar = new JPanel();
    private JPanel buttons = new JPanel();
    private JTextField searchBarTXT = new JTextField();
    private JPanel topPanel = new JPanel();
    private JLayeredPane background = new JDesktopPane();

    // MODIFIES: this
    // EFFECTS: constructs runHotel
    public MenuFrame() throws FileNotFoundException {
        super(TITLE_NAME); // creates the Jframe
        setPreferredSize(new Dimension(X_DIMENSION, Y_DIMENSION));
        setLayout(null);
        setTitle(TITLE_NAME); // sets the title of the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closes the application
        setResizable(false); // sets a fixed window size
        setSize(X_DIMENSION, Y_DIMENSION); // sets x and y dimension
        getContentPane().setBackground(BACKGROUND);
        panelSetup();
        buttonSetup();
        searchBarsetup();
        menuFrameSetup();
    }

    // MODIFIES:  this
    // EFFECTS: creates the panels
    public void panelSetup() {
        image.setLayout(new BorderLayout());
        buttons.setLayout(new FlowLayout());
        searchBar.setLayout(new FlowLayout());
        background.setBounds(0, 0, 800, 800);
        topPanel.setBounds(0, 0, 800,  350);
        image.setBounds(0, 0, 800, 800);
        image.setBackground(Color.white);
        searchBar.setBounds(0, 350, 800, 100);
        buttons.setBounds(0, 450, 800, 350);
        image.setOpaque(true);
        topPanel.setOpaque(true);
        searchBar.setOpaque(true);
        buttons.setOpaque(true);
        background.add(image);
        background.add(topPanel);
        background.add(searchBar);
        background.add(buttons);
        add(background);
    }

    // MODIFIES: this
    // EFFECTS: creates the buttons
    public void buttonSetup() {
        hotelListBttn.setActionCommand("hotelList");
        save.setActionCommand("save");
        load.setActionCommand("load");
        search.setActionCommand("search");
        walletGui.setActionCommand("wallet");
        ImageIcon theImage = new ImageIcon("data/CPSC210Image2.jpeg");
        label = new JLabel(theImage); // creates label
        label.setBounds(0,0, 400, 100);
        image.add(label, BorderLayout.CENTER);
        buttons.add(hotelListBttn);
        buttons.add(walletGui);
        buttons.add(save);
        buttons.add(load);
        hotelListBttn.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        search.addActionListener(this);
        walletGui.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: creates the search bar
    public void searchBarsetup() {
        searchBarTXT.setPreferredSize(new Dimension(350, 50));
        searchBar.add(searchBarTXT);
        searchBar.add(search);
        int position = searchBarTXT.getText().length() / 2;
        searchBarTXT.setCaretPosition(position);
    }

    // MODIFIES: this
    // EFFECTS: creates the menu frame
    public void menuFrameSetup() {
        pack();
        setVisible(true); // so we can see the Jframe
        intiateHotels();
    }

    // MODIFIES: this
    // EFFECTS: processes the command from the start menu
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("search")) {
            hotelSeach();
        }
        if (e.getActionCommand().equals("hotelList")) {
            this.hotelListOptions();
        }
        if (e.getActionCommand().equals("wallet")) {
            this.walletOptions();
        }
        if (e.getActionCommand().equals("save")) {
            this.saveHotelList();
        }
        if (e.getActionCommand().equals("load")) {
            this.loadHotelList();
        }
    }

    // EFFECTS: initiates all the hotels
    private void intiateHotels() {
        this.init();
        this.initBJ();
        this.initSH();
        this.initTJ();
        this.initCD();
        this.initCQ();
        this.initSZ();
        this.initRest();
    }

    // MODIFIES: this
    // EFFECTS: initializes 3 hotels, the hotel list, and the Json data
    private void init() {
        this.hotelList = new HotelList(DEFAULT_LIST_NAME);
        this.input = new Scanner(System.in);
        this.input.useDelimiter("\n");
        this.w1 = new Wallet(500);
        this.gz1 = new Hotel("Langham", 280, "Haizhu");
        this.gz2 = new Hotel("Ritz-carlton", 345, "Tian He");
        this.gz3 = new Hotel("Four Seasons", 378, "Tian He");
        this.jsonWriter = new JsonWriter(JSON_LOCATION);
        this.jsonReader = new JsonReader(JSON_LOCATION);
        this.jsonWriter2 = new JsonWriter(JSON_LOCATION_WALLET);
        this.jsonReader2 = new JsonReader(JSON_LOCATION_WALLET);
    }

    // MODIFIES: this
    // EFFECTS: initializes the hotels in Beijing
    private void initBJ() {
        this.bj1 = new Hotel("Ascott Raffles", 251, "Dongzhimen");
        this.bj2 = new Hotel("Grand Hyatt", 334, "Dongcheng");
        this.bj3 = new Hotel("Rosewood", 445, "Chaoyangmen Outer St");
    }

    // MODIFIES: this
    // EFFECTS: initializes the hotels in Shanghai
    private void initSH() {
        this.sh1 = new Hotel("Shangri-la", 340, "Pu-dong");
        this.sh2 = new Hotel("Ritz-carlton", 368, "Pu-dong");
        this.sh3 = new Hotel("Grand Kempinski", 176, "Pu-dong");
    }

    // MODIFIES: this
    // EFFECTS: initializes the hotels in Tianjin
    private void initTJ() {
        this.tj1 = new Hotel("Ritz-carlton", 225, "Dagubei");
        this.tj2 = new Hotel("Mariott", 100, "Tian Jin Zhi Yan");
        this.tj3 = new Hotel("Crowne Plaza", 110, "Dongli");
    }

    // MODIFIES: this
    // EFFECTS: initializes the hotels in Shenzhen
    private void initSZ() {
        this.sz1 = new Hotel("Langham", 203, "Shenan");
        this.sz2 = new Hotel("Hilton", 183, "Fu Tian");
        this.sz3 = new Hotel("Hilton (Sea World)", 183, "Shekou");
    }

    // MODIFIES: this
    // EFFECTS: initializes the hotels in Chengdu
    private void initCD() {
        this.cd1 = new Hotel("Mariott", 134, "Chenghua");
        this.cd2 = new Hotel("Hilton", 129, "Ju Wei Jiu");
        this.cd3 = new Hotel("Kempinski", 184, "Wangjiang Pavilion Park");
    }

    // MODIFIES: this
    // EFFECTS: initializes the hotels in Chongqing
    private void initCQ() {
        this.cq1 = new Hotel("Niccolo", 216, "Guojin Centre");
        this.cq2 = new Hotel("Crowne Plaza", 116, "Long Hua");
        this.cq3 = new Hotel("Banyan", 358, "Beibei");
    }

    // MODIFIES: this
    // EFFECTS: initializes the rest of the hotels
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

    // MODIFIES: this
    // EFFECTS: gives you options for your hotel list
    public void hotelListOptions() {
        String[] options = {"Remove", "Set name", "View list"};
        int choice = JOptionPane.showOptionDialog(null, "Please select from the following",
                "Conformation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[2]);
        processListCommand(choice);
    }

    // MODIFIES: this
    // EFFECTS: processes the user's input once hotel list has been chosen from the display menu
    private void processListCommand(int choice) {
        if (choice == 2) {
            this.displayList();
        } else if (choice == 0) {
            this.doRemove();
        } else if (choice == 1) {
            this.doSetListName();
        }
    }

    // MODIFIES: this
    // EFFECTS: displays your hotel list
    private void displayList() {
        String message = hotelList.getHotelListNames() + "\n"
                + "Locations: " + hotelList.getHotelLocations() + "\n"
                + "Total price: " + hotelList.getTotalHotelPrices() + "\n"
                + "Total hotels: " + hotelList.length() + "\n"
                + "List full: " + hotelList.listFull() + ", " + "List empty: " + hotelList.listEmpty();
        String hotelListName = hotelList.getListName();
        JOptionPane.showMessageDialog(null,message,hotelListName, JOptionPane.INFORMATION_MESSAGE);
    }

    // MODIFIES: this
    // EFFECTS: removes the first hotel in the list with the name given by the user
    private void doRemove() {
        String remove = JOptionPane.showInputDialog("Enter the name of the hotel you wish to remove ");
        hotelList.removeHotelFromList(remove);
    }

    // MODIFIES: this
    // EFFECTS: sets the name of the user's hotel list
    private void doSetListName() {
        String listName = JOptionPane.showInputDialog("Enter the name in which you want to name your list ");
        hotelList.setListName(listName);
    }

    // MODIFIES: this
    // EFFECTS: presents the interactive functions with the wallet available to the user and takes user input
    private void walletOptions() {
        String [] options = {"Deposit Funds", "View funds", "Test my luck"};
        int choice = JOptionPane.showOptionDialog(null, "Please select from the following",
                "Conformation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[2]);
        processWalletCommand(choice);
    }

    // MODIFIES: this
    // EFFECTS: processes the user's wanted command with the wallet
    private void processWalletCommand(int choice) {
        if (choice == 1) {
            String message = "Your wallet currently contains: " + w1.getAmount() + " CAD";
            JOptionPane.showMessageDialog(null, message);
        } else if (choice == 0) {
            this.depositFunds();
        } else if (choice == 2) {
            this.doRedPocket();
        }
    }

    // REQUIRES: inputted amount has to be a valid integer
    // MODIFIES: this
    // EFFECTS: adds the inputted amount to the user's wallet
    private void depositFunds() {
        String depositStr = JOptionPane.showInputDialog("Enter the amount you wish to deposit: ");
        int depositInt = Integer.parseInt(depositStr);
        w1.addAmount(depositInt);
    }

    // MODIFIES: this
    // EFFECTS: prompts user to buy a red pocket
    private void doRedPocket() {
        String message = "You are about to pay for a red pocket, \n"
                + "A red pocket costs 50 CAD, \n"
                + "In return you will receive a random amount or funds from 0 - 350 CAD, \n"
                + "Select either \"Yes\" to continue or \"No\" to return";
        int choice = JOptionPane.showConfirmDialog(null, message, "Conformation",
                JOptionPane.YES_NO_OPTION);
        cashOutRedPocket(choice);
    }

    // MODIFIES: this
    // EFFECTS: deducts 50 CAD from wallet and adds a random amount between 0 - 300 CAD
    private void cashOutRedPocket(int choice) {
        if (choice == 0 && w1.getAmount() >= 50) {
            w1.subAmount(50);
            rp1 = new RedPocket(1);
            int amount = rp1.getAmount();
            w1.addAmount(amount);
            String message = "Previous amount: " + (w1.getAmount() - amount + 50) + " CAD \n"
                    + "Congrats! You received: " + amount + " CAD \n"
                    + "Current amount: " + w1.getAmount() + " CAD \n";
            JOptionPane.showMessageDialog(null, message);
        } else {
            JOptionPane.showMessageDialog(null, "Red pocket was not purchased",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: prompts the user to enter a supported location
    private void hotelSeach() {
        String location = searchBarTXT.getText();
        location = location.toLowerCase();
        displayHotels(location);
    }

    // MODIFIES: this
    // EFFECTS: processes the user's input from the listDestinations method and displays a list of available hotels
    private void displayHotels(String location) {
        if (location.equals("guangzhou")) {
            gzHotels();
        } else if (location.equals("beijing")) {
            bjHotels();
        } else if (location.equals("shanghai")) {
            shHotels();
        } else if (location.equals("tianjin")) {
            tjHotels();
        } else if (location.equals("shenzhen")) {
            szHotels();
        } else if (location.equals("chengdu")) {
            cdHotels();
        } else if (location.equals("chongqing")) {
            cqHotels();
        } else if (location.equals("dongguan")) {
            dgHotels();
        } else if (location.equals("shenyang")) {
            syHotels();
        } else if (location.equals("wuhan")) {
            whHotels();
        } else {
            JOptionPane.showMessageDialog(null, "Selection not valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user which hotel they want to add
    private void gzHotels() {
        String[] options = {gz1.getName(), gz2.getName(), gz3.getName()};
        String message = "Select the name of the hotel you wish to add \n"
                + gz1.getName() + " Price: " + gz1.getPricePerNight() + " Location: " + gz1.getLocation() + "\n"
                + gz2.getName() + " Price: " + gz2.getPricePerNight() + " Location: " + gz2.getLocation() + "\n"
                + gz3.getName() + " Price: " + gz3.getPricePerNight() + " Location: " + gz3.getLocation();
        int choice = JOptionPane.showOptionDialog(null, message,
                "Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        doAddGZ(choice);
    }

    // MODIFIES: this
    // EFFECTS: if wallet has sufficient funds, adds the selected hotel to the user's hotel list
    private void doAddGZ(int choice) {
        if (choice == 0) {
            if (w1.getAmount() >= gz1.getPricePerNight()) {
                hotelList.addHotelToList(gz1);
                w1.subAmount(gz1.getPricePerNight());
            }
        } else if (choice == 1) {
            if (w1.getAmount() >= gz2.getPricePerNight()) {
                hotelList.addHotelToList(gz2);
                w1.subAmount(gz2.getPricePerNight());
            }
        } else if (choice == 2) {
            if (w1.getAmount() >= gz3.getPricePerNight()) {
                hotelList.addHotelToList(gz3);
                w1.subAmount(gz3.getPricePerNight());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hotel was not added, insufficient funds",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user which hotel they want to add
    private void bjHotels() {
        String[] options = {bj1.getName(), bj2.getName(), bj3.getName()};
        String message = "Select the name of the hotel you wish to add \n"
                + bj1.getName() + " Price: " + bj1.getPricePerNight() + " Location: " + bj1.getLocation() + "\n"
                + bj2.getName() + " Price: " + bj2.getPricePerNight() + " Location: " + bj2.getLocation() + "\n"
                + bj3.getName() + " Price: " + bj3.getPricePerNight() + " Location: " + bj3.getLocation();
        int choice = JOptionPane.showOptionDialog(null, message,
                "Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        doAddBJ(choice);
    }

    // MODIFIES: this
    // EFFECTS: if wallet has sufficient funds, adds the selected hotel to the user's hotel list
    private void doAddBJ(int choice) {
        if (choice == 0) {
            if (w1.getAmount() >= bj1.getPricePerNight()) {
                hotelList.addHotelToList(bj1);
                w1.subAmount(bj1.getPricePerNight());
            }
        } else if (choice == 1) {
            if (w1.getAmount() >= bj2.getPricePerNight()) {
                hotelList.addHotelToList(bj2);
                w1.subAmount(bj2.getPricePerNight());
            }
        } else if (choice == 2) {
            if (w1.getAmount() >= bj3.getPricePerNight()) {
                hotelList.addHotelToList(bj3);
                w1.subAmount(bj3.getPricePerNight());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hotel was not added, insufficient funds",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user which hotel they want to add
    private void shHotels() {
        String[] options = {sh1.getName(), sh2.getName(), sh3.getName()};
        String message = "Select the name of the hotel you wish to add \n"
                + sh1.getName() + " Price: " + sh1.getPricePerNight() + " Location: " + sh1.getLocation() + "\n"
                + sh2.getName() + " Price: " + sh2.getPricePerNight() + " Location: " + sh2.getLocation() + "\n"
                + sh3.getName() + " Price: " + sh3.getPricePerNight() + " Location: " + sh3.getLocation();
        int choice = JOptionPane.showOptionDialog(null, message,
                "Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        doAddSH(choice);
    }

    // MODIFIES: this
    // EFFECTS: if wallet has sufficient funds, adds the selected hotel to the user's hotel list
    private void doAddSH(int choice) {
        if (choice == 0) {
            if (w1.getAmount() >= sh1.getPricePerNight()) {
                hotelList.addHotelToList(sh1);
                w1.subAmount(sh1.getPricePerNight());
            }
        } else if (choice == 1) {
            if (w1.getAmount() >= sh2.getPricePerNight()) {
                hotelList.addHotelToList(sh2);
                w1.subAmount(sh2.getPricePerNight());
            }
        } else if (choice == 2) {
            if (w1.getAmount() >= sh3.getPricePerNight()) {
                hotelList.addHotelToList(sh3);
                w1.subAmount(sh3.getPricePerNight());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hotel was not added, insufficient funds",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user which hotel they want to add
    private void tjHotels() {
        String[] options = {tj1.getName(), tj2.getName(), tj3.getName()};
        String message = "Select the name of the hotel you wish to add \n"
                + tj1.getName() + " Price: " + tj1.getPricePerNight() + " Location: " + tj1.getLocation() + "\n"
                + tj2.getName() + " Price: " + tj2.getPricePerNight() + " Location: " + tj2.getLocation() + "\n"
                + tj3.getName() + " Price: " + tj3.getPricePerNight() + " Location: " + tj3.getLocation();
        int choice = JOptionPane.showOptionDialog(null, message,
                "Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        doAddTJ(choice);
    }

    // MODIFIES: this
    // EFFECTS: if wallet has sufficient funds, adds the selected hotel to the user's hotel list
    private void doAddTJ(int choice) {
        if (choice == 0) {
            if (w1.getAmount() >= tj1.getPricePerNight()) {
                hotelList.addHotelToList(tj1);
                w1.subAmount(tj1.getPricePerNight());
            }
        } else if (choice == 1) {
            if (w1.getAmount() >= tj2.getPricePerNight()) {
                hotelList.addHotelToList(tj2);
                w1.subAmount(tj2.getPricePerNight());
            }
        } else if (choice == 2) {
            if (w1.getAmount() >= tj3.getPricePerNight()) {
                hotelList.addHotelToList(tj3);
                w1.subAmount(tj3.getPricePerNight());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hotel was not added, insufficient funds",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user which hotel they want to add
    private void szHotels() {
        String[] options = {sz1.getName(), sz2.getName(), sz3.getName()};
        String message = "Select the name of the hotel you wish to add \n"
                + sz1.getName() + " Price: " + sz1.getPricePerNight() + " Location: " + sz1.getLocation() + "\n"
                + sz2.getName() + " Price: " + sz2.getPricePerNight() + " Location: " + sz2.getLocation() + "\n"
                + sz3.getName() + " Price: " + sz3.getPricePerNight() + " Location: " + sz3.getLocation();
        int choice = JOptionPane.showOptionDialog(null, message,
                "Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        doAddSZ(choice);
    }

    // MODIFIES: this
    // EFFECTS: if wallet has sufficient funds, adds the selected hotel to the user's hotel list
    private void doAddSZ(int choice) {
        if (choice  == 0) {
            if (w1.getAmount() >= sz1.getPricePerNight()) {
                hotelList.addHotelToList(sz1);
                w1.subAmount(sz1.getPricePerNight());
            }
        } else if (choice == 1) {
            if (w1.getAmount() >= sz2.getPricePerNight()) {
                hotelList.addHotelToList(sz2);
                w1.subAmount(sz2.getPricePerNight());
            }
        } else if (choice == 2) {
            if (w1.getAmount() >= sz3.getPricePerNight()) {
                hotelList.addHotelToList(sz3);
                w1.subAmount(sz3.getPricePerNight());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hotel was not added, insufficient funds",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user which hotel they want to add
    private void cdHotels() {
        String[] options = {cd1.getName(), cd2.getName(), cd3.getName()};
        String message = "Select the name of the hotel you wish to add \n"
                + cd1.getName() + " Price: " + cd1.getPricePerNight() + " Location: " + cd1.getLocation() + "\n"
                + cd2.getName() + " Price: " + cd2.getPricePerNight() + " Location: " + cd2.getLocation() + "\n"
                + cd3.getName() + " Price: " + cd3.getPricePerNight() + " Location: " + cd3.getLocation();
        int choice = JOptionPane.showOptionDialog(null, message,
                "Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        doAddCD(choice);
    }

    // MODIFIES: this
    // EFFECTS: if wallet has sufficient funds, adds the selected hotel to the user's hotel list
    private void doAddCD(int choice) {
        if (choice  == 0) {
            if (w1.getAmount() >= cd1.getPricePerNight()) {
                hotelList.addHotelToList(cd1);
                w1.subAmount(cd1.getPricePerNight());
            }
        } else if (choice == 1) {
            if (w1.getAmount() >= cd2.getPricePerNight()) {
                hotelList.addHotelToList(cd2);
                w1.subAmount(cd2.getPricePerNight());
            }
        } else if (choice == 2) {
            if (w1.getAmount() >= cd3.getPricePerNight()) {
                hotelList.addHotelToList(cd3);
                w1.subAmount(cd3.getPricePerNight());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hotel was not added, insufficient funds",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user which hotel they want to add
    private void cqHotels() {
        String[] options = {cq1.getName(), cq2.getName(), cq3.getName()};
        String message = "Select the name of the hotel you wish to add \n"
                + cq1.getName() + " Price: " + cq1.getPricePerNight() + " Location: " + cq1.getLocation() + "\n"
                + cq2.getName() + " Price: " + cq2.getPricePerNight() + " Location: " + cq2.getLocation() + "\n"
                + cq3.getName() + " Price: " + cq3.getPricePerNight() + " Location: " + cq3.getLocation();
        int choice = JOptionPane.showOptionDialog(null, message,
                "Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        doAddCQ(choice);
    }

    // MODIFIES: this
    // EFFECTS: if wallet has sufficient funds, adds the selected hotel to the user's hotel list
    private void doAddCQ(int choice) {
        if (choice == 0) {
            if (w1.getAmount() >= cq1.getPricePerNight()) {
                hotelList.addHotelToList(cq1);
                w1.subAmount(cq1.getPricePerNight());
            }
        } else if (choice == 1) {
            if (w1.getAmount() >= cq2.getPricePerNight()) {
                hotelList.addHotelToList(cq2);
                w1.subAmount(cq2.getPricePerNight());
            }
        } else if (choice == 2) {
            if (w1.getAmount() >= cq3.getPricePerNight()) {
                hotelList.addHotelToList(cq3);
                w1.subAmount(cq3.getPricePerNight());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hotel was not added, insufficient funds",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user which hotel they want to add
    private void dgHotels() {
        String[] options = {dg1.getName(), dg2.getName(), dg3.getName()};
        String message = "Select the name of the hotel you wish to add \n"
                + dg1.getName() + " Price: " + dg1.getPricePerNight() + " Location: " + dg1.getLocation() + "\n"
                + dg2.getName() + " Price: " + dg2.getPricePerNight() + " Location: " + dg2.getLocation() + "\n"
                + dg3.getName() + " Price: " + dg3.getPricePerNight() + " Location: " + dg3.getLocation();
        int choice = JOptionPane.showOptionDialog(null, message,
                "Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        doAddDG(choice);
    }

    // MODIFIES: this
    // EFFECTS: if wallet has sufficient funds, adds the selected hotel to the user's hotel list
    private void doAddDG(int choice) {
        if (choice  == 0) {
            if (w1.getAmount() >= dg1.getPricePerNight()) {
                hotelList.addHotelToList(dg1);
                w1.subAmount(dg1.getPricePerNight());
            }
        } else if (choice == 1) {
            if (w1.getAmount() >= dg2.getPricePerNight()) {
                hotelList.addHotelToList(dg2);
                w1.subAmount(dg2.getPricePerNight());
            }
        } else if (choice == 2) {
            if (w1.getAmount() >= dg3.getPricePerNight()) {
                hotelList.addHotelToList(dg3);
                w1.subAmount(dg3.getPricePerNight());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hotel was not added, insufficient funds",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user which hotel they want to add
    private void syHotels() {
        String[] options = {sy1.getName(), sy2.getName(), sy3.getName()};
        String message = "Select the name of the hotel you wish to add \n"
                + sy1.getName() + " Price: " + sy1.getPricePerNight() + " Location: " + sy1.getLocation() + "\n"
                + sy2.getName() + " Price: " + sy2.getPricePerNight() + " Location: " + sy2.getLocation() + "\n"
                + sy3.getName() + " Price: " + sy3.getPricePerNight() + " Location: " + sy3.getLocation();
        int choice = JOptionPane.showOptionDialog(null, message,
                "Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        doAddSY(choice);
    }

    // MODIFIES: this
    // EFFECTS: if wallet has sufficient funds, adds the selected hotel to the user's hotel list
    private void doAddSY(int choice) {
        if (choice == 0) {
            if (w1.getAmount() >= sy1.getPricePerNight()) {
                hotelList.addHotelToList(sy1);
                w1.subAmount(sy1.getPricePerNight());
            }
        } else if (choice == 1) {
            if (w1.getAmount() >= sy2.getPricePerNight()) {
                hotelList.addHotelToList(sy2);
                w1.subAmount(sy2.getPricePerNight());
            }
        } else if (choice == 2) {
            if (w1.getAmount() >= sy3.getPricePerNight()) {
                hotelList.addHotelToList(sy3);
                w1.subAmount(sy3.getPricePerNight());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hotel was not added, insufficient funds",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: Asks user which hotel they want to add
    private void whHotels() {
        String[] options = {wh1.getName(), wh2.getName(), wh3.getName()};
        String message = "Select the name of the hotel you wish to add \n"
                + wh1.getName() + " Price: " + wh1.getPricePerNight() + " Location: " + wh1.getLocation() + "\n"
                + wh2.getName() + " Price: " + wh2.getPricePerNight() + " Location: " + wh2.getLocation() + "\n"
                + wh3.getName() + " Price: " + wh3.getPricePerNight() + " Location: " + wh3.getLocation();
        int choice = JOptionPane.showOptionDialog(null, message,
                "Selection", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                options[0]);
        doAddWH(choice);
    }

    // MODIFIES: this
    // EFFECTS: if wallet has sufficient funds, adds the selected hotel to the user's hotel list
    private void doAddWH(int choice) {
        if (choice == 0) {
            if (w1.getAmount() >= wh1.getPricePerNight()) {
                hotelList.addHotelToList(wh1);
                w1.subAmount(wh1.getPricePerNight());
            }
        } else if (choice == 1) {
            if (w1.getAmount() >= wh2.getPricePerNight()) {
                hotelList.addHotelToList(wh2);
                w1.subAmount(wh2.getPricePerNight());
            }
        } else if (choice == 2) {
            if (w1.getAmount() >= wh3.getPricePerNight()) {
                hotelList.addHotelToList(wh3);
                w1.subAmount(wh3.getPricePerNight());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hotel was not added, insufficient funds",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFIES: this
    // EFFECTS: asks user if they want to save hotel list
    private void saveHotelList() {
        String message = "Would you like to save your list?";
        int choice = JOptionPane.showConfirmDialog(null, message, "Conformation",
                JOptionPane.YES_NO_OPTION);
        saveHotelListConfirmation(choice);
    }

    // MODIFIES: this
    // EFFECTS: tries to save the Hotel list as a jsonObject, if unsuccessful, throws file not found exception
    private  void saveHotelListConfirmation(int choice) {
        if (choice == 0) {
            try {
                jsonWriter.open();
                jsonWriter.write(hotelList);
                jsonWriter.close();
                walletSave();
                JOptionPane.showMessageDialog(null, "Save Successful");
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Unable to write to file: " + JSON_LOCATION);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: asks user if they want to load hotel list
    private void loadHotelList() {
        String message = "Would you like to load your list?";
        int choice = JOptionPane.showConfirmDialog(null, message, "Conformation",
                JOptionPane.YES_NO_OPTION);
        loadHotelListConfirmation(choice);
    }

    // MODIFIES: this
    // Effects: tries to load the Hotel list from the jsonObject, if unsuccessful, throws IOException
    private void loadHotelListConfirmation(int choice) {
        if (choice == 0) {
            try {
                hotelList = jsonReader.read();
                JOptionPane.showMessageDialog(null,
                        "Loaded " + hotelList.getListName() + " from " + JSON_LOCATION);
                this.loadWallet();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null,
                        "Unable to read from file: " + JSON_LOCATION);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: asks user if they want to save wallet
    private void walletSave() {
        try {
            jsonWriter2.open();
            jsonWriter2.writeWallet(w1);
            jsonWriter2.close();
            System.out.println("Saved your wallet to " + JSON_LOCATION_WALLET);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_LOCATION_WALLET);
        }
    }

    // MODIFIES: this
    // EFFECTS: tries to load the wallet from the jsonObject, if unsuccessful, throws IOException
    private void loadWallet() {
        try {
            w1 = jsonReader2.readWallet();
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_LOCATION_WALLET);
        }
    }

}

