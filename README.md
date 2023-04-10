# ExplrAsia


#

### **Current Supported List of Locations** :
- Guangzhou
- Beijing
- Shanghai
- Tianjin
- Shenzhen
- Chengdu
- Chongqing
- Dongguan
- Shenyang
- Wuhan

#

## My story

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Some of my earliest and fondest 
memories as a toddler consisted of late night car adventures 
and overnight stays in the suites of Guangzhou’s 
most prolific hotels. This was the result of my family’s 
heavy involvement in the hotel industry in the western 
parts of China. Specifically, the sensation of a warm 
and welcoming hotel lobby after a long day of work and 
travels presented me with great peace and comfort. 
As it was said by Diane von Furstenburg, 
*“When you get into a hotel room, you lock the door, 
and you know there is secrecy, there is a luxury, 
there is fantasy, there is comfort, and there is 
assurance”*. My ambition with this project is to share 
the luxuries and comforts, that I had once felt, with 
the touring individuals and families looking to capture 
an essence of the beauty within some of Asia’s most 
glorious destinations.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
Balancing hotel hunting and planning the itinerary for 
your special work-trip, vacation, or stay-cation may seem 
like a daunting and overwhelming task. This application 
is designed to ease and simplify the process of hotel 
seeking for tourists and travellers looking to explore 
the Asian continent. Specifically, users will be able to 
state their desired destination and will promptly be 
greeted with various researched and reviewed hotel 
recommendations. In addition to this, consumers also 
have the ability to sort their generated results based 
on both price and location. Moreover, once a hotel has 
caught the interest of a user, they will be able to add 
that hotel to their list where they can read a writeup about the hotel and access the hotel’s official website.

#

### **User Stories**
- As a user, I want to be able to enter a city name
- As a user, I want to be able to see generated results based on my desired destination
- As a user, I want to be able to add a hotel listing to my current travelling list
- As a user, I want to be able to name my list
- As a user, I want to be able to view my list
- As a user, I want to be able to delete hotel listings from my list
- As a user, I want to be able to see how many hotel listings I have in my list
- As a user, I want to be able to view the locations of the hotels in my list
- As a user, I want to be able to have a virtual wallet
- As a user, I want to be able to add funds to my wallet
- As a user, I want to be able to view how much funds I have in my wallet
- As a user, I want to be able to spend a certain amount of money to get a random amount of money in return
- As a user, I want to only be able to add hotels in my list only if I have sufficient funds for at least one night in my wallet
- As a user, I want to be reminded that I am able to have the option to 
save my hotel list to a file when exiting the program
- As a user, I want to be given the option to load my hotel list
- As a user, I want my wallet to be auto-saved
- As a user, I want my wallet to be auto-loaded 

#

### Instructions for Grader
- You can generate the first required action related to adding Xs to a Y by adding a hotel to your hotel list.
If you are first accessing the application, navigate to the wallet
button. Once there click the view funds button and ensure at least 500 CAD is
in your wallet. You are now ready to complete the first required action.
This is done by typing the name of a city in the search bar, then clicking the search button. Then
click the button with the name of the hotel you wish to add. You can view the addition by returning to 
the menu and clicking the hotel list button. Once there, click the view list button.
- You can generate the second required action related to adding Xs to a Y by removing a hotel from your hotel list.
  This is done by clicking the hotel list button from the menu. Once there, click the remove button.
Then, type the name of the hotel you wish to remove and click ok. You can see the removal by 
navigating back to hotel list button. Once there, click the view list button.
- You can locate my visual component by returning to the main menu, it is the background image.
- You can save the state of my application by clicking the save button from the menu. When prompted, 
select yes.
- You can reload the state of my application by clicking the load button from the menu. When prompted,
select yes.

#

### Phase 4: Task 2
Sun Apr 09 18:39:30 PDT 2023
  User added: 100000 to their wallet

Sun Apr 09 18:39:37 PDT 2023
User added: Ascott Raffles to their list: Hotel list

Sun Apr 09 18:39:39 PDT 2023
User added: Grand Hyatt to their list: Hotel list

Sun Apr 09 18:39:41 PDT 2023
User added: Rosewood to their list: Hotel list

Sun Apr 09 18:39:46 PDT 2023
User added: Four Seasons to their list: Hotel list

Sun Apr 09 18:39:48 PDT 2023
User added: Ritz-carlton to their list: Hotel list

Sun Apr 09 18:39:49 PDT 2023
User added: Langham to their list: Hotel list

Sun Apr 09 18:39:54 PDT 2023
User's hotel list name has been set to: dom

Sun Apr 09 18:40:11 PDT 2023
User removed: Langham from their list: dom

Sun Apr 09 18:40:23 PDT 2023
User tried to remove: Ritz-Carlton from their list: dom but it was not in their list

Sun Apr 09 18:40:35 PDT 2023
User removed: Ritz-carlton from their list: dom

Sun Apr 09 18:40:43 PDT 2023
User added: Shangri-la to their list: dom

Sun Apr 09 18:40:44 PDT 2023
User added: Ritz-carlton to their list: dom

Sun Apr 09 18:40:45 PDT 2023
User added: Grand Kempinski to their list: dom

Sun Apr 09 18:40:53 PDT 2023
User added: Mariott to their list: dom

Sun Apr 09 18:40:55 PDT 2023
User added: Hilton to their list: dom

Sun Apr 09 18:40:56 PDT 2023
User added: Kempinski to their list: dom

Sun Apr 09 18:41:07 PDT 2023
User tried to add: Mission Hills from their list: dom but list was full

Process finished with exit code 0

#

### Phase 4: Task 3
- 	With time, any project could be improved, updated, and perfected. It is for this reason that if I were provided with more time to improve my personal project, I would utilize refactoring to further revamp the coupling in my application. Specifically, I would make changes to the graphical user interface-based code in which hotels are added to the user’s hotel list. In the application’s current state, the code that dictates showing the user hotel options as well as the software that handles the user’s choice contain multiple instances of duplicated code. In order to better the application, I would utilize abstraction to transform the duplicate code into methods which would assist in removing code clones. Specifically, implementing an abstract or interface-based class would undoubtedly allow for easier code maintenance and flexibility in the implementation of future features. In addition to this, the refactoring of my code would also ease the process of resuing my code. As an illustration, if I were tasked with engineering an application similar to this one, the improved abstraction would lend itself over as I would be free of having to recreate the same code for similar methods and tasks. In conclusion, refactoring of my code is an important technique that would assist me to write better code that is easier to maintain and manage over the course of my journey into software design.

#

## **Citations**
- Description: Java code on data persistence 
- Author: Paul Carter 
- Date accessed: Mar 8, 2023
- URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/tree/master/src/main/persistence